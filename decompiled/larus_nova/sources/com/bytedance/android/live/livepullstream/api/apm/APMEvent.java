package com.bytedance.android.live.livepullstream.api.apm;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public class APMEvent {

    @SerializedName("key")
    private String mKey;

    @SerializedName("level")
    private Level mLevel;

    @SerializedName("message")
    private String mMessage;

    @SerializedName("timestamp")
    private long mTimeStamp;

    public static final enum Level extends Enum<Level> {
        public static final Level E = null;
        public static final Level I = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Level[] f82511a = null;

        static {
            Level r100 = new Level("I", 0);
            I = r100;
            Level r101 = new Level(ExifInterface.LONGITUDE_EAST, 1);
            E = r101;
            f82511a = new Level[]{r100, r101};
        }

        public static Level[] values() {
            return (Level[]) f82511a.clone();
        }

        public static Level valueOf(String r100) {
            return (Level) r27.a.a(Level.class, r100);
        }

        public Level(String r100, int r101) {
            super(r100, r101);
        }
    }

    public APMEvent() {
    }

    public final JSONObject h() {
        JSONObject r100 = new JSONObject();
        r100.put("level", this.mLevel);     // Catch: JSONException -> L8
        r100.put("key", this.mKey);     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(this.mMessage) == true) goto L6;
        r100.put("message", this.mMessage);     // Catch: JSONException -> L8
    L6:
        r100.put("timestamp", this.mTimeStamp);     // Catch: JSONException -> L8
    L10:
        return r100;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public final String toString() {
        return "key:" + this.mKey + " message:" + this.mMessage;
    }

    public final String a() {
        return this.mKey;
    }

    public final Level b() {
        return this.mLevel;
    }

    public final String c() {
        return this.mMessage;
    }

    public final void d(String r100) {
        this.mKey = r100;
    }

    public final void e(Level r100) {
        this.mLevel = r100;
    }

    public final void f(String r100) {
        this.mMessage = r100;
    }

    public final void g(long r100) {
        this.mTimeStamp = r100;
    }
}
