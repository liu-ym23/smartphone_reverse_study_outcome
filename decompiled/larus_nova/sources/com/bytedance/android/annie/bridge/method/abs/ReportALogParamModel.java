package com.bytedance.android.annie.bridge.method.abs;

import com.bytedance.android.annie.bridge.method.util.EnumJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u0016B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel;", "", "", "message", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$Level;", "level", "Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$Level;", "b", "()Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$Level;", "setLevel", "(Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$Level;)V", "tag", "d", "setTag", "Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$a;", "codePosition", "Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$a;", "setCodePosition", "(Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$a;)V", "<init>", "()V", "Level", "LevelAdapter", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class ReportALogParamModel {

    @SerializedName("codePosition")
    private a codePosition;

    @SerializedName("level")
    @JsonAdapter(LevelAdapter.class)
    private Level level;

    @SerializedName("message")
    private String message;

    @SerializedName("tag")
    private String tag;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$Level;", "", "", "toString", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Error", "Warn", "Debug", "Verbose", "Info", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Level extends Enum<Level> {
        public static final a Companion = null;
        public static final Level Debug = null;
        public static final Level Error = null;
        public static final Level Info = null;
        public static final Level Verbose = null;
        public static final Level Warn = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Level[] f38531a = null;

        public static final class a {
            public a() {
            }
        }

        public static Level valueOf(String r100) {
            return (Level) r27.a.a(Level.class, r100);
        }

        public static Level[] values() {
            return (Level[]) f38531a.clone();
        }

        static {
            Level r100 = new Level("Error", 0);
            Error = r100;
            Level r101 = new Level("Warn", 1);
            Warn = r101;
            Level r102 = new Level("Debug", 2);
            Debug = r102;
            Level r103 = new Level("Verbose", 3);
            Verbose = r103;
            Level r104 = new Level("Info", 4);
            Info = r104;
            f38531a = new Level[]{r100, r101, r102, r103, r104};
            Companion = new a();
        }

        @Override // java.lang.Enum
        public String toString() {
            if (this != Error) goto L6;
            return "error";
        L6:
            if (this != Warn) goto L9;
            return "warn";
        L9:
            if (this != Debug) goto L12;
            return "debug";
        L12:
            if (this != Verbose) goto L15;
            return "verbose";
        L15:
            if (this != Info) goto L17;
            return "info";
        L17:
            return "";
        }

        public Level(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$LevelAdapter;", "Lcom/bytedance/android/annie/bridge/method/util/EnumJsonAdapter;", "Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$Level;", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class LevelAdapter extends EnumJsonAdapter<Level> {
        public LevelAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            if (r100.peek() != JsonToken.NULL) goto L7;
            r100.nextNull();
            return null;
        L7:
            String r101 = r100.nextString();
            Level.Companion.getClass();
            Intrinsics.checkNotNullParameter(r101, "level");
            if (StringsKt.equals(r101, "error", true) == false) goto L11;
            return Level.Error;
        L11:
            if (StringsKt.equals(r101, "warn", true) == false) goto L14;
            return Level.Warn;
        L14:
            if (StringsKt.equals(r101, "debug", true) == false) goto L17;
            return Level.Debug;
        L17:
            if (StringsKt.equals(r101, "verbose", true) == false) goto L20;
            return Level.Verbose;
        L20:
            if (StringsKt.equals(r101, "info", true) == true) goto L22;
            return null;
        L22:
            return Level.Info;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$a;", "", "", "file", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setFile", "(Ljava/lang/String;)V", "", "line", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setLine", "(Ljava/lang/Integer;)V", "function", "b", "setFunction", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("file")
        private String file;

        @SerializedName("function")
        private String function;

        @SerializedName("line")
        private Integer line;

        public a() {
        }

        public final String a() {
            return this.file;
        }

        public final String b() {
            return this.function;
        }

        public final Integer c() {
            return this.line;
        }
    }

    public ReportALogParamModel() {
    }

    public final a a() {
        return this.codePosition;
    }

    public final Level b() {
        return this.level;
    }

    public final String c() {
        return this.message;
    }

    public final String d() {
        return this.tag;
    }
}
