package com.stepos.aiengine.algorithm.asr;

import La.z;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001:\u000389:B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001c\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J/\u0010!\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\"R\u0018\u0010/\u001a\u00060+j\u0002`,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00101R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006;"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker;", "", "", "cumulativeDelta", "<init>", "(Z)V", "", "currentIndex", "()I", "", "delta", "", "startMs", "endMs", "speakerId", "confirmed", "Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$DeltaOutcome;", "recordDelta", "(Ljava/lang/String;JJLjava/lang/String;Z)Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$DeltaOutcome;", "serverText", "Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$RecognizedEvent;", "completeSegment", "(Ljava/lang/String;JJLjava/lang/String;)Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$RecognizedEvent;", "text", "Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$ForcedOutcome;", "emitForcedSegment", "(Ljava/lang/String;JJLjava/lang/String;)Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$ForcedOutcome;", "fallbackText", "closeAfterAbort", "flushBeforeTerminal", "()Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$RecognizedEvent;", "hasOpenSegment", "()Z", Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "lock", "c", "I", "segmentIndex", Const.INTENT_KEY_UMID, "segmentOpen", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "e", "Ljava/lang/StringBuilder;", "segmentText", "f", "J", "segmentStartMs", Const.INTENT_KEY_BACKGROUND_COMMAND, "segmentEndMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/String;", "segmentSpeakerId", "RecognizedEvent", "DeltaOutcome", "ForcedOutcome", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsrStreamSegmentTracker {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean cumulativeDelta;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int segmentIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean segmentOpen;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final StringBuilder segmentText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public long segmentStartMs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public long segmentEndMs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public String segmentSpeakerId;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$DeltaOutcome;", "", "", "index", "", "segmentOpened", "<init>", "(IZ)V", "component1", "()I", "component2", "()Z", ChatTracker.CLICK_COPY, "(IZ)Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$DeltaOutcome;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getIndex", Const.INTENT_KEY_PKGNAME, "Z", "getSegmentOpened", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class DeltaOutcome {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int index;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean segmentOpened;

        public DeltaOutcome(int i10, boolean z10) {
            this.index = i10;
            this.segmentOpened = z10;
        }

        public static /* synthetic */ DeltaOutcome copy$default(DeltaOutcome deltaOutcome, int i10, boolean z10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = deltaOutcome.index;
            }
            if ((i11 & 2) != 0) {
                z10 = deltaOutcome.segmentOpened;
            }
            return deltaOutcome.copy(i10, z10);
        }

        /* renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getSegmentOpened() {
            return this.segmentOpened;
        }

        public final DeltaOutcome copy(int index, boolean segmentOpened) {
            return new DeltaOutcome(index, segmentOpened);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeltaOutcome)) {
                return false;
            }
            DeltaOutcome deltaOutcome = (DeltaOutcome) other;
            return this.index == deltaOutcome.index && this.segmentOpened == deltaOutcome.segmentOpened;
        }

        public final int getIndex() {
            return this.index;
        }

        public final boolean getSegmentOpened() {
            return this.segmentOpened;
        }

        public int hashCode() {
            return (Integer.hashCode(this.index) * 31) + Boolean.hashCode(this.segmentOpened);
        }

        public String toString() {
            return "DeltaOutcome(index=" + this.index + ", segmentOpened=" + this.segmentOpened + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$ForcedOutcome;", "", "Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$RecognizedEvent;", "event", "", "segmentOpened", "<init>", "(Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$RecognizedEvent;Z)V", "component1", "()Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$RecognizedEvent;", "component2", "()Z", ChatTracker.CLICK_COPY, "(Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$RecognizedEvent;Z)Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$ForcedOutcome;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$RecognizedEvent;", "getEvent", Const.INTENT_KEY_PKGNAME, "Z", "getSegmentOpened", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ForcedOutcome {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final RecognizedEvent event;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean segmentOpened;

        public ForcedOutcome(RecognizedEvent event, boolean z10) {
            p.i(event, "event");
            this.event = event;
            this.segmentOpened = z10;
        }

        public static /* synthetic */ ForcedOutcome copy$default(ForcedOutcome forcedOutcome, RecognizedEvent recognizedEvent, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                recognizedEvent = forcedOutcome.event;
            }
            if ((i10 & 2) != 0) {
                z10 = forcedOutcome.segmentOpened;
            }
            return forcedOutcome.copy(recognizedEvent, z10);
        }

        /* renamed from: component1, reason: from getter */
        public final RecognizedEvent getEvent() {
            return this.event;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getSegmentOpened() {
            return this.segmentOpened;
        }

        public final ForcedOutcome copy(RecognizedEvent event, boolean segmentOpened) {
            p.i(event, "event");
            return new ForcedOutcome(event, segmentOpened);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ForcedOutcome)) {
                return false;
            }
            ForcedOutcome forcedOutcome = (ForcedOutcome) other;
            return p.d(this.event, forcedOutcome.event) && this.segmentOpened == forcedOutcome.segmentOpened;
        }

        public final RecognizedEvent getEvent() {
            return this.event;
        }

        public final boolean getSegmentOpened() {
            return this.segmentOpened;
        }

        public int hashCode() {
            return (this.event.hashCode() * 31) + Boolean.hashCode(this.segmentOpened);
        }

        public String toString() {
            return "ForcedOutcome(event=" + this.event + ", segmentOpened=" + this.segmentOpened + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000fJB\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000fJ\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\rJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010#\u001a\u0004\b&\u0010\u0011R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\u000f¨\u0006)"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$RecognizedEvent;", "", "", "index", "", "text", "", "startTime", "endTime", "speakerId", "<init>", "(ILjava/lang/String;JJLjava/lang/String;)V", "component1", "()I", "component2", "()Ljava/lang/String;", "component3", "()J", "component4", "component5", ChatTracker.CLICK_COPY, "(ILjava/lang/String;JJLjava/lang/String;)Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$RecognizedEvent;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getIndex", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "getText", "c", "J", "getStartTime", Const.INTENT_KEY_UMID, "getEndTime", "e", "getSpeakerId", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class RecognizedEvent {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int index;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String text;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final long startTime;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final long endTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final String speakerId;

        public RecognizedEvent(int i10, String text, long j10, long j11, String speakerId) {
            p.i(text, "text");
            p.i(speakerId, "speakerId");
            this.index = i10;
            this.text = text;
            this.startTime = j10;
            this.endTime = j11;
            this.speakerId = speakerId;
        }

        public static /* synthetic */ RecognizedEvent copy$default(RecognizedEvent recognizedEvent, int i10, String str, long j10, long j11, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = recognizedEvent.index;
            }
            if ((i11 & 2) != 0) {
                str = recognizedEvent.text;
            }
            if ((i11 & 4) != 0) {
                j10 = recognizedEvent.startTime;
            }
            if ((i11 & 8) != 0) {
                j11 = recognizedEvent.endTime;
            }
            if ((i11 & 16) != 0) {
                str2 = recognizedEvent.speakerId;
            }
            String str3 = str2;
            long j12 = j11;
            return recognizedEvent.copy(i10, str, j10, j12, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component3, reason: from getter */
        public final long getStartTime() {
            return this.startTime;
        }

        /* renamed from: component4, reason: from getter */
        public final long getEndTime() {
            return this.endTime;
        }

        /* renamed from: component5, reason: from getter */
        public final String getSpeakerId() {
            return this.speakerId;
        }

        public final RecognizedEvent copy(int index, String text, long startTime, long endTime, String speakerId) {
            p.i(text, "text");
            p.i(speakerId, "speakerId");
            return new RecognizedEvent(index, text, startTime, endTime, speakerId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecognizedEvent)) {
                return false;
            }
            RecognizedEvent recognizedEvent = (RecognizedEvent) other;
            return this.index == recognizedEvent.index && p.d(this.text, recognizedEvent.text) && this.startTime == recognizedEvent.startTime && this.endTime == recognizedEvent.endTime && p.d(this.speakerId, recognizedEvent.speakerId);
        }

        public final long getEndTime() {
            return this.endTime;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getSpeakerId() {
            return this.speakerId;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.index) * 31) + this.text.hashCode()) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31) + this.speakerId.hashCode();
        }

        public String toString() {
            return "RecognizedEvent(index=" + this.index + ", text=" + this.text + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", speakerId=" + this.speakerId + ")";
        }
    }

    public AsrStreamSegmentTracker() {
        this(false, 1, null);
    }

    public final RecognizedEvent a(String text, long startMs, long endMs, String speakerId) {
        String str;
        String str2;
        int i10 = this.segmentIndex;
        if (startMs <= 0) {
            startMs = this.segmentStartMs;
        }
        long j10 = startMs;
        long j11 = endMs > 0 ? endMs : this.segmentEndMs;
        if (speakerId.length() > 0) {
            str = text;
            str2 = speakerId;
        } else if (this.segmentSpeakerId.length() > 0) {
            str = text;
            str2 = this.segmentSpeakerId;
        } else {
            str = text;
            str2 = "";
        }
        RecognizedEvent recognizedEvent = new RecognizedEvent(i10, str, j10, j11, str2);
        this.segmentOpen = false;
        z.q(this.segmentText);
        this.segmentStartMs = 0L;
        this.segmentEndMs = 0L;
        this.segmentSpeakerId = "";
        this.segmentIndex++;
        return recognizedEvent;
    }

    public final RecognizedEvent closeAfterAbort(String fallbackText, long startMs, long endMs, String speakerId) {
        p.i(fallbackText, "fallbackText");
        p.i(speakerId, "speakerId");
        synchronized (this.lock) {
            try {
                if (!this.segmentOpen) {
                    return null;
                }
                if (fallbackText.length() == 0) {
                    fallbackText = this.segmentText.toString();
                    p.h(fallbackText, "toString(...)");
                }
                return a(fallbackText, startMs, endMs, speakerId);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final RecognizedEvent completeSegment(String serverText, long startMs, long endMs, String speakerId) {
        p.i(serverText, "serverText");
        p.i(speakerId, "speakerId");
        synchronized (this.lock) {
            if (!this.segmentOpen) {
                return null;
            }
            return a(serverText, startMs, endMs, speakerId);
        }
    }

    public final int currentIndex() {
        int i10;
        synchronized (this.lock) {
            i10 = this.segmentIndex;
        }
        return i10;
    }

    public final ForcedOutcome emitForcedSegment(String text, long startMs, long endMs, String speakerId) {
        p.i(text, "text");
        p.i(speakerId, "speakerId");
        synchronized (this.lock) {
            if (text.length() == 0) {
                return null;
            }
            return new ForcedOutcome(a(text, startMs, endMs, speakerId), !this.segmentOpen);
        }
    }

    public final RecognizedEvent flushBeforeTerminal() {
        synchronized (this.lock) {
            if (!this.segmentOpen) {
                return null;
            }
            String string = this.segmentText.toString();
            p.h(string, "toString(...)");
            return a(string, this.segmentStartMs, this.segmentEndMs, this.segmentSpeakerId);
        }
    }

    public final boolean hasOpenSegment() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.segmentOpen;
        }
        return z10;
    }

    public final DeltaOutcome recordDelta(String delta, long startMs, long endMs, String speakerId, boolean confirmed) {
        p.i(delta, "delta");
        p.i(speakerId, "speakerId");
        synchronized (this.lock) {
            if (delta.length() == 0) {
                return new DeltaOutcome(this.segmentIndex, false);
            }
            boolean z10 = this.segmentOpen;
            boolean z11 = !z10;
            if (!z10) {
                z.q(this.segmentText);
                this.segmentStartMs = 0L;
                this.segmentEndMs = 0L;
                this.segmentSpeakerId = "";
            }
            this.segmentOpen = true;
            if (!this.cumulativeDelta) {
                this.segmentText.append(delta);
            } else if (confirmed) {
                this.segmentText.setLength(0);
                this.segmentText.append(delta);
            } else if (this.segmentText.length() == 0) {
                this.segmentText.append(delta);
            } else {
                t tVar = t.f7040a;
            }
            if (startMs > 0 && this.segmentStartMs == 0) {
                this.segmentStartMs = startMs;
            }
            if (endMs > this.segmentEndMs) {
                this.segmentEndMs = endMs;
            }
            if (speakerId.length() > 0) {
                this.segmentSpeakerId = speakerId;
            }
            return new DeltaOutcome(this.segmentIndex, z11);
        }
    }

    public AsrStreamSegmentTracker(boolean z10) {
        this.cumulativeDelta = z10;
        this.lock = new Object();
        this.segmentText = new StringBuilder();
        this.segmentSpeakerId = "";
    }

    public /* synthetic */ AsrStreamSegmentTracker(boolean z10, int i10, i iVar) {
        this((i10 & 1) != 0 ? false : z10);
    }
}
