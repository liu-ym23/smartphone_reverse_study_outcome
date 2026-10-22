package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/InputMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", CardAdapter.TEXT, "ASR", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputMode extends Enum<InputMode> {
    public static final InputMode ASR = null;
    public static final a Companion = null;
    public static final InputMode TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputMode[] f35510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f35511b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static InputMode a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            InputMode r101 = InputMode.TEXT;
            if (Intrinsics.areEqual(r100, r101.getValue()) == true) goto L7;
            r101 = InputMode.ASR;
            if (Intrinsics.areEqual(r100, r101.getValue()) == true) goto L7;
            throw new IllegalArgumentException("No enum constant " + r100);
        L7:
            return r101;
        }
    }

    public static EnumEntries<InputMode> getEntries() {
        return f35511b;
    }

    static {
        InputMode r100 = new InputMode(CardAdapter.TEXT, 0, "text");
        TEXT = r100;
        InputMode r101 = new InputMode("ASR", 1, "asr");
        ASR = r101;
        InputMode[] r102 = {r100, r101};
        f35510a = r102;
        f35511b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static InputMode[] values() {
        return (InputMode[]) f35510a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static InputMode valueOf(String r100) {
        return (InputMode) r27.a.a(InputMode.class, r100);
    }

    public InputMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
