package com.android.server.pm;

import android.util.Slog;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsXml {
    private static final boolean DEBUG_THROW_EXCEPTIONS = false;
    private static final int DEFAULT_NUMBER = -1;
    private static final String FEATURE_INDENT = "http://xmlpull.org/v1/doc/features.html#indent-output";
    private static final String TAG = "SettingsXml";

    public interface ChildSection extends ReadSection {
        boolean moveToNext();

        boolean moveToNext(String r1);
    }

    public interface ReadSection extends AutoCloseable {
        ChildSection children();

        boolean getBoolean(String r1);

        boolean getBoolean(String r1, boolean r2);

        String getDescription();

        int getInt(String r1);

        int getInt(String r1, int r2);

        long getLong(String r1);

        long getLong(String r1, int r2);

        String getName();

        String getString(String r1);

        String getString(String r1, String r2);

        boolean has(String r1);
    }

    public static class ReadSectionImpl implements ChildSection {
        private final Stack<Integer> mDepthStack;
        private final InputStream mInput;
        private final TypedXmlPullParser mParser;

        public ReadSectionImpl(InputStream input) throws IOException, XmlPullParserException {
            this.mDepthStack = new Stack();
            this.mInput = input;
            this.mParser = Xml.newFastPullParser();
            this.mParser.setInput(this.mInput, StandardCharsets.UTF_8.name());
            moveToFirstTag();
        }

        public ReadSectionImpl(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            this.mDepthStack = new Stack();
            this.mInput = null;
            this.mParser = parser;
            moveToFirstTag();
        }

        private void moveToFirstTag() throws IOException, XmlPullParserException {
            if (this.mParser.getEventType() != 2) goto L5;
            return;
        L5:
            int type = this.mParser.next();
            if (type == 2) goto L10;
            if (type != 1) goto L5;
            return;
        }

        @Override // com.android.server.pm.SettingsXml.ReadSection
        public String getName() {
            return this.mParser.getName();
        }

        @Override // com.android.server.pm.SettingsXml.ReadSection
        public String getDescription() {
            return this.mParser.getPositionDescription();
        }

        @Override // com.android.server.pm.SettingsXml.ReadSection
        public boolean has(String attrName) {
            if (this.mParser.getAttributeValue(null, attrName) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.pm.SettingsXml.ReadSection
        public String getString(String attrName) {
            return this.mParser.getAttributeValue(null, attrName);
        }

        @Override // com.android.server.pm.SettingsXml.ReadSection
        public String getString(String attrName, String defaultValue) {
            String value = this.mParser.getAttributeValue(null, attrName);
            if (value != null) goto L5;
            return defaultValue;
        L5:
            return value;
        }

        @Override // com.android.server.pm.SettingsXml.ReadSection
        public boolean getBoolean(String attrName) {
            return getBoolean(attrName, false);
        }

        @Override // com.android.server.pm.SettingsXml.ReadSection
        public boolean getBoolean(String attrName, boolean defaultValue) {
            return this.mParser.getAttributeBoolean(null, attrName, defaultValue);
        }

        @Override // com.android.server.pm.SettingsXml.ReadSection
        public int getInt(String attrName) {
            return getInt(attrName, -1);
        }

        @Override // com.android.server.pm.SettingsXml.ReadSection
        public int getInt(String attrName, int defaultValue) {
            return this.mParser.getAttributeInt(null, attrName, defaultValue);
        }

        @Override // com.android.server.pm.SettingsXml.ReadSection
        public long getLong(String attrName) {
            return getLong(attrName, -1);
        }

        @Override // com.android.server.pm.SettingsXml.ReadSection
        public long getLong(String attrName, int defaultValue) {
            return this.mParser.getAttributeLong(null, attrName, defaultValue);
        }

        @Override // com.android.server.pm.SettingsXml.ReadSection
        public ChildSection children() {
            this.mDepthStack.push(Integer.valueOf(this.mParser.getDepth()));
            return this;
        }

        @Override // com.android.server.pm.SettingsXml.ChildSection
        public boolean moveToNext() {
            return moveToNextInternal(null);
        }

        @Override // com.android.server.pm.SettingsXml.ChildSection
        public boolean moveToNext(String expectedChildTagName) {
            return moveToNextInternal(expectedChildTagName);
        }

        private boolean moveToNextInternal(String expectedChildTagName) {
            int depth = this.mDepthStack.peek().intValue();     // Catch: Exception -> L11
            boolean hasTag = false;
        L3:
            if (hasTag == true) goto L21;
            int type = this.mParser.next();     // Catch: Exception -> L11
            if (type == 1) goto L21;
            if (type != 3) goto L14;
            if (this.mParser.getDepth() <= depth) goto L21;
        L14:
            if (type != 2) goto L3;
            if (expectedChildTagName == null) goto L20;
            if (expectedChildTagName.equals(this.mParser.getName()) == false) goto L3;
        L20:
            hasTag = true;
        L21:
            if (hasTag == true) goto L23;
            this.mDepthStack.pop();     // Catch: Exception -> L11
        L23:
            return hasTag;
        L24:
            return false;
        }

        @Override // java.lang.AutoCloseable
        public void close() throws Exception {
            if (this.mDepthStack.isEmpty() == false) goto L6;
            Slog.wtf(SettingsXml.TAG, "Children depth stack was not empty, data may have been lost", new Exception());
        L6:
            if (this.mInput == null) goto L9;
            this.mInput.close();
            return;
        }
    }

    public static class Serializer implements AutoCloseable {
        private final WriteSectionImpl mWriteSection;
        private final TypedXmlSerializer mXmlSerializer;

        /* synthetic */ Serializer(TypedXmlSerializer r1, SettingsXmlIA r2) {
            this(r1);
        }

        private Serializer(TypedXmlSerializer serializer) {
            this.mXmlSerializer = serializer;
            this.mWriteSection = new WriteSectionImpl(this.mXmlSerializer, null);
        }

        public WriteSection startSection(String sectionName) throws IOException {
            return this.mWriteSection.startSection(sectionName);
        }

        @Override // java.lang.AutoCloseable
        public void close() throws IOException {
            WriteSectionImpl.m6897$$Nest$mcloseCompletely(this.mWriteSection);
            this.mXmlSerializer.flush();
        }
    }

    public interface WriteSection extends AutoCloseable {
        WriteSection attribute(String r1, int r2) throws IOException;

        WriteSection attribute(String r1, long r2) throws IOException;

        WriteSection attribute(String r1, String r2) throws IOException;

        WriteSection attribute(String r1, boolean r2) throws IOException;

        @Override // java.lang.AutoCloseable
        void close() throws IOException;

        void finish() throws IOException;

        WriteSection startSection(String r1) throws IOException;
    }

    private static class WriteSectionImpl implements WriteSection {
        private final Stack<String> mTagStack;
        private final TypedXmlSerializer mXmlSerializer;

        /* JADX INFO: renamed from: -$$Nest$mcloseCompletely, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6897$$Nest$mcloseCompletely(WriteSectionImpl r0) {
            r0.closeCompletely();
        }

        /* synthetic */ WriteSectionImpl(TypedXmlSerializer r1, SettingsXmlIA r2) {
            this(r1);
        }

        private WriteSectionImpl(TypedXmlSerializer xmlSerializer) {
            this.mTagStack = new Stack();
            this.mXmlSerializer = xmlSerializer;
        }

        @Override // com.android.server.pm.SettingsXml.WriteSection
        public WriteSection startSection(String sectionName) throws IOException {
            this.mXmlSerializer.startTag(null, sectionName);
            this.mTagStack.push(sectionName);
            return this;
        }

        @Override // com.android.server.pm.SettingsXml.WriteSection
        public WriteSection attribute(String attrName, String value) throws IOException {
            if (value == null) goto L4;
            this.mXmlSerializer.attribute(null, attrName, value);
        L4:
            return this;
        }

        @Override // com.android.server.pm.SettingsXml.WriteSection
        public WriteSection attribute(String attrName, int value) throws IOException {
            if (value == (-1)) goto L5;
            this.mXmlSerializer.attributeInt(null, attrName, value);
        L5:
            return this;
        }

        @Override // com.android.server.pm.SettingsXml.WriteSection
        public WriteSection attribute(String attrName, long value) throws IOException {
            if (value == (-1)) goto L5;
            this.mXmlSerializer.attributeLong(null, attrName, value);
        L5:
            return this;
        }

        @Override // com.android.server.pm.SettingsXml.WriteSection
        public WriteSection attribute(String attrName, boolean value) throws IOException {
            if (value == false) goto L4;
            this.mXmlSerializer.attributeBoolean(null, attrName, value);
        L4:
            return this;
        }

        @Override // com.android.server.pm.SettingsXml.WriteSection
        public void finish() throws IOException {
            close();
        }

        @Override // com.android.server.pm.SettingsXml.WriteSection, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mXmlSerializer.endTag(null, this.mTagStack.pop());
        }

        private void closeCompletely() throws IOException {
            if (this.mTagStack != null) goto L5;
            return;
        L5:
            if (this.mTagStack.isEmpty() == true) goto L9;
            close();
            goto L5
        }
    }

    public SettingsXml() {
    }

    public static Serializer serializer(TypedXmlSerializer serializer) {
        return new Serializer(serializer, null);
    }

    public static ReadSection parser(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        return new ReadSectionImpl(parser);
    }
}
