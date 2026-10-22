package com.bytedance.android.livesdk.interactivity.service.emoji.recent;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/emoji/recent/b;", "", "", "description", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "latestUseTime", "J", "getLatestUseTime", "()J", "e", "(J)V", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/interactivity/service/emoji/recent/a;", "latestUseCount", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("description")
    private final String description;

    @SerializedName("latest_use_count")
    private final ArrayList<a> latestUseCount;

    @SerializedName("latest_use_time")
    private long latestUseTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L8;
        return false;
    L8:
        if (this.latestUseTime == r101.latestUseTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.latestUseCount, r101.latestUseCount) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.description;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.latestUseTime;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        ArrayList<a> r105 = this.latestUseCount;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return r104 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RecentEmoji(description=" + this.description + ", latestUseTime=" + this.latestUseTime + ", latestUseCount=" + this.latestUseCount + ")";
    }

    public b() {
        this(null, 0, new ArrayList());
    }

    public final long d() {
        ArrayList<a> r100 = this.latestUseCount;
        long r101 = 0;
        if (r100 == null) goto L8;
        Iterator<a> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101 = r101 + r102.next().a();
    L8:
        return r101;
    }

    public final String b() {
        return this.description;
    }

    public final ArrayList<a> c() {
        return this.latestUseCount;
    }

    public final void e(long r100) {
        this.latestUseTime = r100;
    }

    public b(String r100, long r101, ArrayList<a> r102) {
        this.description = r100;
        this.latestUseTime = r101;
        this.latestUseCount = r102;
    }

    public final float a(long r110, int r111, db2.b r112) {
        Intrinsics.checkNotNullParameter(r112, "shortcutEmojiParams");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L10
        float r101 = r112.a();     // Catch: Throwable -> L10
        float r102 = r112.b();     // Catch: Throwable -> L10
        float r103 = r112.c();     // Catch: Throwable -> L10
        float r104 = r112.d();     // Catch: Throwable -> L10
        return (float) (Math.pow((r101 * ((float) ((0.4f + (0.6f * Math.exp(((((System.currentTimeMillis() - this.latestUseTime) / 1000.0f) / 3600.0f) / 24.0f) * (-0.5f)))) * ((double) ((d() - 0.0f) / (r110 - 0.0f)))))) + 1.0f, r103) * Math.pow(1 + (r102 * (r111 / 100.0f)), r104));
    L8:
        th = th;
    L12:
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return 1.0f;
    L10:
        th = th;
        goto L12
    }
}
