package com.android.server.power.stats;

import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.TimeUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.google.android.collect.Sets;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class PowerStatsSpan implements AutoCloseable {
    private static final DateTimeFormatter DATE_FORMAT = null;
    private static final String TAG = "PowerStatsStore";
    private static final int VERSION = 2;
    private static final String XML_ATTR_DURATION = "duration";
    private static final String XML_ATTR_ID = "id";
    private static final String XML_ATTR_MONOTONIC = "monotonic";
    private static final String XML_ATTR_SECTION_TYPE = "type";
    private static final String XML_ATTR_START_TIME = "start";
    private static final String XML_ATTR_VERSION = "version";
    private static final String XML_TAG_METADATA = "metadata";
    private static final String XML_TAG_SECTION = "section";
    private static final String XML_TAG_TIMEFRAME = "timeframe";
    private final Metadata mMetadata;
    private final List<Section> mSections;

    public static class Metadata {
        static final Comparator<Metadata> COMPARATOR = null;
        private final long mId;
        private final List<String> mSections;
        private final List<TimeFrame> mTimeFrames;

        /* JADX INFO: renamed from: -$$Nest$fgetmId, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m7843$$Nest$fgetmId(Metadata r2) {
            return r2.mId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTimeFrames, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m7844$$Nest$fgetmTimeFrames(Metadata r0) {
            return r0.mTimeFrames;
        }

        static {
            COMPARATOR = Comparator.comparing(new PowerStatsSpan$Metadata$$ExternalSyntheticLambda0());
        }

        Metadata(long id) {
            this.mTimeFrames = new ArrayList();
            this.mSections = new ArrayList();
            this.mId = id;
        }

        public long getId() {
            return this.mId;
        }

        public List<TimeFrame> getTimeFrames() {
            return this.mTimeFrames;
        }

        public List<String> getSections() {
            return this.mSections;
        }

        void addTimeFrame(TimeFrame timeFrame) {
            this.mTimeFrames.add(timeFrame);
        }

        long getStartTime() {
            long startTime = Long.MAX_VALUE;
            int i = 0;
        L4:
            if (i >= this.mTimeFrames.size()) goto L10;
            TimeFrame timeFrame = this.mTimeFrames.get(i);
            if (timeFrame.startTime >= startTime) goto L8;
            startTime = timeFrame.startTime;
        L8:
            i = i + 1;
            goto L4
        L10:
            if (startTime != Long.MAX_VALUE) goto L17;
            return 0;
        L17:
            return startTime;
        }

        long getStartMonotonicTime() {
            long startTime = Long.MAX_VALUE;
            int i = 0;
        L4:
            if (i >= this.mTimeFrames.size()) goto L10;
            TimeFrame timeFrame = this.mTimeFrames.get(i);
            if (timeFrame.startMonotonicTime >= startTime) goto L8;
            startTime = timeFrame.startMonotonicTime;
        L8:
            i = i + 1;
            goto L4
        L10:
            if (startTime != Long.MAX_VALUE) goto L17;
            return -1;
        L17:
            return startTime;
        }

        long getEndMonotonicTime() {
            long maxTime = Long.MIN_VALUE;
            int i = 0;
        L4:
            if (i >= this.mTimeFrames.size()) goto L10;
            TimeFrame timeFrame = this.mTimeFrames.get(i);
            long endTime = timeFrame.startMonotonicTime + timeFrame.duration;
            if (endTime <= maxTime) goto L8;
            maxTime = endTime;
        L8:
            i = i + 1;
            goto L4
        L10:
            if (maxTime != Long.MIN_VALUE) goto L17;
            return -1;
        L17:
            return maxTime;
        }

        void addSection(String sectionType) {
            if (this.mSections.contains(sectionType) == true) goto L6;
            this.mSections.add(sectionType);
            return;
        }

        void write(TypedXmlSerializer serializer) throws IOException {
            serializer.startTag(null, PowerStatsSpan.XML_TAG_METADATA);
            serializer.attributeLong(null, PowerStatsSpan.XML_ATTR_ID, this.mId);
            serializer.attributeInt(null, PowerStatsSpan.XML_ATTR_VERSION, 2);
            Iterator<TimeFrame> r2 = this.mTimeFrames.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            TimeFrame timeFrame = r2.next();
            timeFrame.write(serializer);
            goto L4
        L6:
            Iterator<String> r3 = this.mSections.iterator();
        L8:
            if (r3.hasNext() == false) goto L10;
            String section = r3.next();
            serializer.startTag(null, PowerStatsSpan.XML_TAG_SECTION);
            serializer.attribute(null, "type", section);
            serializer.endTag(null, PowerStatsSpan.XML_TAG_SECTION);
            goto L8
        L10:
            serializer.endTag(null, PowerStatsSpan.XML_TAG_METADATA);
        }

        public static Metadata read(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            Metadata metadata = null;
            int eventType = parser.getEventType();
        L4:
            if (eventType == 1) goto L27;
            if (eventType != 3) goto L10;
            if (parser.getName().equals(PowerStatsSpan.XML_TAG_METADATA) == true) goto L27;
        L10:
            if (eventType != 2) goto L26;
            String tagName = parser.getName();
            if (tagName.equals(PowerStatsSpan.XML_TAG_METADATA) == false) goto L18;
            int version = parser.getAttributeInt(null, PowerStatsSpan.XML_ATTR_VERSION);
            if (PowerStatsSpan.m7842$$Nest$smisCompatibleXmlFormat(version) == false) goto L15;
            long id = parser.getAttributeLong(null, PowerStatsSpan.XML_ATTR_ID);
            Metadata metadata2 = new Metadata(id);
            metadata = metadata2;
            goto L26
        L15:
            Slog.e(PowerStatsSpan.TAG, "Incompatible version " + version + "; expected 2");
            return null;
        L18:
            if (metadata != null) goto L20;
        L22:
            if (metadata == null) goto L26;
            if (tagName.equals(PowerStatsSpan.XML_TAG_SECTION) == false) goto L26;
            metadata.addSection(parser.getAttributeValue(null, "type"));
            goto L26
        L20:
            if (tagName.equals(PowerStatsSpan.XML_TAG_TIMEFRAME) == false) goto L22;
            metadata.addTimeFrame(TimeFrame.read(parser));
        L26:
            eventType = parser.next();
        L27:
            return metadata;
        }

        public void dump(IndentingPrintWriter pw) {
            dump(pw, true);
        }

        void dump(IndentingPrintWriter pw, boolean includeSections) {
            pw.print("Span ");
            if (this.mTimeFrames.size() <= 0) goto L5;
            this.mTimeFrames.get(0).dump(pw);
            pw.println();
        L5:
            int i = 1;
        L7:
            if (i >= this.mTimeFrames.size()) goto L10;
            TimeFrame timeFrame = this.mTimeFrames.get(i);
            pw.print("     ");
            timeFrame.dump(pw);
            pw.println();
            i = i + 1;
            goto L7
        L10:
            if (includeSections == false) goto L19;
            pw.increaseIndent();
            Iterator<String> r0 = this.mSections.iterator();
        L13:
            if (r0.hasNext() == false) goto L15;
            String section = r0.next();
            pw.print(PowerStatsSpan.XML_TAG_SECTION, section);
            pw.println();
            goto L13
        L15:
            pw.decreaseIndent();
            return;
        }

        public String toString() {
            StringWriter sw = new StringWriter();
            IndentingPrintWriter ipw = new IndentingPrintWriter(sw);
            ipw.print(PowerStatsSpan.XML_ATTR_ID, Long.valueOf(this.mId));
            int i = 0;
        L4:
            if (i >= this.mTimeFrames.size()) goto L6;
            TimeFrame timeFrame = this.mTimeFrames.get(i);
            ipw.print("timeframe=[");
            timeFrame.dump(ipw);
            ipw.print("] ");
            i = i + 1;
            goto L4
        L6:
            Iterator<String> r2 = this.mSections.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            String section = r2.next();
            ipw.print(PowerStatsSpan.XML_TAG_SECTION, section);
            goto L8
        L10:
            ipw.flush();
            return sw.toString().trim();
        }
    }

    public static abstract class Section {
        private final String mType;

        /* JADX INFO: renamed from: -$$Nest$fgetmType, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m7845$$Nest$fgetmType(Section r0) {
            return r0.mType;
        }

        public abstract void write(TypedXmlSerializer r1) throws IOException;

        protected Section(String type) {
            this.mType = type;
        }

        public String getType() {
            return this.mType;
        }

        public void dump(IndentingPrintWriter ipw) {
            ipw.println(this.mType);
        }

        public void close() {
        }
    }

    public interface SectionReader {
        String getType();

        Section read(String r1, TypedXmlPullParser r2) throws IOException, XmlPullParserException;
    }

    public static class TimeFrame {
        public final long duration;
        public final long startMonotonicTime;
        public final long startTime;

        TimeFrame(long startMonotonicTime, long startTime, long duration) {
            this.startMonotonicTime = startMonotonicTime;
            this.startTime = startTime;
            this.duration = duration;
        }

        void write(TypedXmlSerializer serializer) throws IOException {
            serializer.startTag(null, PowerStatsSpan.XML_TAG_TIMEFRAME);
            serializer.attributeLong(null, "start", this.startTime);
            serializer.attributeLong(null, PowerStatsSpan.XML_ATTR_MONOTONIC, this.startMonotonicTime);
            serializer.attributeLong(null, "duration", this.duration);
            serializer.endTag(null, PowerStatsSpan.XML_TAG_TIMEFRAME);
        }

        static TimeFrame read(TypedXmlPullParser parser) throws XmlPullParserException {
            return new TimeFrame(parser.getAttributeLong(null, PowerStatsSpan.XML_ATTR_MONOTONIC), parser.getAttributeLong(null, "start"), parser.getAttributeLong(null, "duration"));
        }

        public void dump(IndentingPrintWriter pw) {
            StringBuilder sb = new StringBuilder();
            sb.append(PowerStatsSpan.m7841$$Nest$sfgetDATE_FORMAT().format(Instant.ofEpochMilli(this.startTime)));
            sb.append(" (monotonic=");
            sb.append(this.startMonotonicTime);
            sb.append(") ");
            sb.append(" duration=");
            String durationString = TimeUtils.formatDuration(this.duration);
            if (durationString.startsWith("+") == false) goto L5;
            sb.append(durationString.substring(1));
        L6:
            pw.print(sb);
            return;
        L5:
            sb.append(durationString);
            goto L6
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDATE_FORMAT, reason: not valid java name */
    static /* bridge */ /* synthetic */ DateTimeFormatter m7841$$Nest$sfgetDATE_FORMAT() {
        return DATE_FORMAT;
    }

    /* JADX INFO: renamed from: -$$Nest$smisCompatibleXmlFormat, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7842$$Nest$smisCompatibleXmlFormat(int r0) {
        return isCompatibleXmlFormat(r0);
    }

    static {
        DATE_FORMAT = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss.SSS").withZone(ZoneId.systemDefault());
    }

    public PowerStatsSpan(long id) {
        this(new Metadata(id));
    }

    private PowerStatsSpan(Metadata metadata) {
        this.mSections = new ArrayList();
        this.mMetadata = metadata;
    }

    public Metadata getMetadata() {
        return this.mMetadata;
    }

    public long getId() {
        return Metadata.m7843$$Nest$fgetmId(this.mMetadata);
    }

    public void addTimeFrame(long monotonicTime, long wallClockTime, long duration) {
        Metadata.m7844$$Nest$fgetmTimeFrames(this.mMetadata).add(new TimeFrame(monotonicTime, wallClockTime, duration));
    }

    public void addSection(Section section) {
        this.mMetadata.addSection(section.getType());
        this.mSections.add(section);
    }

    public List<Section> getSections() {
        return this.mSections;
    }

    private static boolean isCompatibleXmlFormat(int version) {
        if (version != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void writeXml(OutputStream out, TypedXmlSerializer serializer) throws IOException {
        serializer.setOutput(out, StandardCharsets.UTF_8.name());
        serializer.startDocument(null, true);
        this.mMetadata.write(serializer);
        Iterator<Section> r0 = this.mSections.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Section section = r0.next();
        serializer.startTag(null, XML_TAG_SECTION);
        serializer.attribute(null, "type", Section.m7845$$Nest$fgetmType(section));
        section.write(serializer);
        serializer.endTag(null, XML_TAG_SECTION);
        goto L4
    L6:
        serializer.endDocument();
    }

    static PowerStatsSpan read(InputStream in, TypedXmlPullParser parser, Map<String, SectionReader> sectionReaders, String... sectionTypes) throws IOException, XmlPullParserException {
        TypedXmlPullParser r0 = parser;
        Set<String> neededSections = Sets.newArraySet(sectionTypes);
        int r3 = 1;
        boolean selectSections = !neededSections.isEmpty();
        r0.setInput(in, StandardCharsets.UTF_8.name());
        Metadata metadata = Metadata.read(r0);
        if (metadata != null) goto L5;
        return null;
    L5:
        PowerStatsSpan span = new PowerStatsSpan(metadata);
        boolean skipSection = false;
        int nestingLevel = 0;
        int eventType = r0.getEventType();
    L6:
        if (eventType == r3) goto L48;
        if (skipSection == true) goto L10;
        if (eventType != 2) goto L46;
        String tag = r0.getName();
        if (tag.equals(XML_TAG_SECTION) == false) goto L43;
        final String sectionType = r0.getAttributeValue(null, "type");
        if (selectSections == true) goto L29;
    L32:
        Section section = null;
        SectionReader sectionReader = sectionReaders.get(sectionType);
        if (sectionReader == null) goto L35;
        section = sectionReader.read(sectionType, r0);
    L35:
        if (section != null) goto L40;
        if (selectSections == true) goto L39;
        section = new AnonymousClass1(sectionType, sectionType);
        goto L40
    L39:
        throw new XmlPullParserException("Unsupported PowerStatsStore section type: " + sectionType);
    L40:
        span.addSection(section);
        goto L46
    L29:
        if (neededSections.contains(sectionType) == true) goto L32;
        skipSection = true;
        goto L46
    L43:
        if (tag.equals(XML_TAG_METADATA) == false) goto L46;
        Metadata.read(parser);
    L46:
        eventType = parser.next();
        r0 = parser;
        r3 = 1;
        goto L6
    L10:
        if (eventType == 3) goto L12;
    L17:
        if (eventType != 2) goto L46;
        if (r0.getName().equals(XML_TAG_SECTION) == false) goto L46;
        nestingLevel = nestingLevel + 1;
        goto L46
    L12:
        if (r0.getName().equals(XML_TAG_SECTION) == false) goto L17;
        nestingLevel = nestingLevel - 1;
        if (nestingLevel != 0) goto L46;
        skipSection = false;
        goto L46
    L48:
        return span;
    }

    public void dump(IndentingPrintWriter ipw) {
        this.mMetadata.dump(ipw, false);
        Iterator<Section> r0 = this.mSections.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Section section = r0.next();
        ipw.increaseIndent();
        ipw.println(Section.m7845$$Nest$fgetmType(section));
        section.dump(ipw);
        ipw.decreaseIndent();
        goto L4
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        int i = 0;
    L4:
        if (i >= this.mSections.size()) goto L7;
        this.mSections.get(i).close();
        i = i + 1;
        goto L4
    }
}
