package com.stepos.core.ability.speech;

import com.stepos.core.data.ContentParams;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsStreamingBuffer {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_TTS_FEED_EOF = "tts_feed_eof";
    public static final String KEY_TTS_FEED_ORDERED = "tts_feed_ordered";
    public static final String KEY_TTS_FEED_SEQ = "tts_feed_seq";
    public static final String KEY_TTS_FEED_TOTAL = "tts_feed_total";
    public static final String KEY_TTS_INPUT_CLOSED = "tts.input.closed";
    public static final String KEY_TTS_SESSION_OPENED = "tts.session.opened";
    public static final String KEY_TTS_STREAM_START = "tts_stream_start";
    private final ConcurrentHashMap.KeySetView<String, Boolean> registered = ConcurrentHashMap.newKeySet();
    private final ConcurrentHashMap<String, List<String>> pendingText = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class FeedResult {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ FeedResult[] $VALUES;
        public static final FeedResult Forward = new FeedResult("Forward", 0);
        public static final FeedResult Stashed = new FeedResult("Stashed", 1);
        public static final FeedResult NotStreaming = new FeedResult("NotStreaming", 2);

        private static final /* synthetic */ FeedResult[] $values() {
            return new FeedResult[]{Forward, Stashed, NotStreaming};
        }

        static {
            FeedResult[] feedResultArr$values = $values();
            $VALUES = feedResultArr$values;
            $ENTRIES = kotlin.enums.a.a(feedResultArr$values);
        }

        private FeedResult(String str, int i10) {
        }

        public static sb.a<FeedResult> getEntries() {
            return $ENTRIES;
        }

        public static FeedResult valueOf(String str) {
            return (FeedResult) Enum.valueOf(FeedResult.class, str);
        }

        public static FeedResult[] values() {
            return (FeedResult[]) $VALUES.clone();
        }
    }

    public final void cancelAll() {
        this.registered.clear();
        this.pendingText.clear();
    }

    public final FeedResult feed(String inferId, Content input) {
        List<String> listPutIfAbsent;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        if (!(input instanceof TextContent) || ((TextContent) input).getText().length() == 0) {
            return FeedResult.NotStreaming;
        }
        if (this.registered.contains(inferId)) {
            return FeedResult.Forward;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = this.pendingText;
        List<String> arrayList = concurrentHashMap.get(inferId);
        if (arrayList == null && (listPutIfAbsent = concurrentHashMap.putIfAbsent(inferId, (arrayList = new ArrayList<>()))) != null) {
            arrayList = listPutIfAbsent;
        }
        List<String> list = arrayList;
        synchronized (list) {
            list.add(((TextContent) input).getText());
        }
        return FeedResult.Stashed;
    }

    public final boolean isRegistered(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        return this.registered.contains(inferId);
    }

    public final boolean isStreamingStart(Content input) {
        ContentParams params;
        kotlin.jvm.internal.g.f(input, "input");
        return (input instanceof TextContent) && (params = ((TextContent) input).getParams()) != null && params.getBoolean(KEY_TTS_STREAM_START, false);
    }

    public final void register(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        this.registered.add(inferId);
    }

    public final List<String> takePending(String inferId) {
        List<String> listO0;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        List<String> listRemove = this.pendingText.remove(inferId);
        if (listRemove == null) {
            return EmptyList.f10001a;
        }
        synchronized (listRemove) {
            listO0 = kotlin.collections.a.O0(listRemove);
        }
        return listO0;
    }

    public final void unregister(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        this.registered.remove(inferId);
        this.pendingText.remove(inferId);
    }
}
