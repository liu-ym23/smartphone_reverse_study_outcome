package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.util.LongSparseArray;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f143568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f143569g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f143570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f143571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f143572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f143573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f143574e;

    public static final class a {
        public a() {
        }

        public static void a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "cb");
            if (p.f143568f == true) goto L5;
            return;
        L5:
            KtvContext.Companion.getClass();
            LongSparseArray<p> r101 = KtvContext.a.g().getLyricStateRecordMap();
            int r102 = r101.size();
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L8;
            r100.invoke(r101.valueAt(r103));
            r103 = r103 + 1;
            goto L6
        }
    }

    static {
        f143569g = new a();
    }

    public final String toString() {
        return "LyricStateRecord(mId=0, emptyViewVisible=" + this.f143570a + ", emptyViewState=" + this.f143571b + ", singingDuration=null, singingStartTime=null, isLyricVisible=" + this.f143572c + ", isLyricInfoPrepare=" + this.f143573d + ", showState=null, haveUrl=" + this.f143574e + ')';
    }
}
