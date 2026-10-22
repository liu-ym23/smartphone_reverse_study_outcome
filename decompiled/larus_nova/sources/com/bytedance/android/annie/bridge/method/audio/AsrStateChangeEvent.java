package com.bytedance.android.annie.bridge.method.audio;

import com.google.gson.annotations.SerializedName;
import e7.j0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/audio/AsrStateChangeEvent;", "", "Lcom/bytedance/android/annie/bridge/method/audio/AsrStateChangeEvent$Type;", "type", "Lcom/bytedance/android/annie/bridge/method/audio/AsrStateChangeEvent$Type;", "getType", "()Lcom/bytedance/android/annie/bridge/method/audio/AsrStateChangeEvent$Type;", "setType", "(Lcom/bytedance/android/annie/bridge/method/audio/AsrStateChangeEvent$Type;)V", "", "textMsg", "Ljava/lang/String;", "getTextMsg", "()Ljava/lang/String;", "setTextMsg", "(Ljava/lang/String;)V", "", "isConnected", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setConnected", "(Ljava/lang/Boolean;)V", "<init>", "()V", "Type", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class AsrStateChangeEvent {

    @SerializedName("isConnected")
    private Boolean isConnected;

    @SerializedName("textMsg")
    private String textMsg;

    @SerializedName("type")
    private Type type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/audio/AsrStateChangeEvent$Type;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Started", "GetResulted", "Finished", "Failed", "WebSocketStateChanged", "GetPartialResulted", "GetAudioFile", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> implements j0 {
        public static final Type Failed = null;
        public static final Type Finished = null;
        public static final Type GetAudioFile = null;
        public static final Type GetPartialResulted = null;
        public static final Type GetResulted = null;
        public static final Type Started = null;
        public static final Type WebSocketStateChanged = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f38543a = null;
        private final int value;

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f38543a.clone();
        }

        static {
            Type r100 = new Type("Started", 0, 100);
            Started = r100;
            Type r101 = new Type("GetResulted", 1, 101);
            GetResulted = r101;
            Type r102 = new Type("Finished", 2, 102);
            Finished = r102;
            Type r103 = new Type("Failed", 3, 103);
            Failed = r103;
            Type r104 = new Type("WebSocketStateChanged", 4, 104);
            WebSocketStateChanged = r104;
            Type r105 = new Type("GetPartialResulted", 5, 105);
            GetPartialResulted = r105;
            Type r110 = new Type("GetAudioFile", 6, 106);
            GetAudioFile = r110;
            f38543a = new Type[]{r100, r101, r102, r103, r104, r105, r110};
        }

        @Override // e7.j0
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public AsrStateChangeEvent() {
    }

    public final Type getType() {
        return this.type;
    }
}
