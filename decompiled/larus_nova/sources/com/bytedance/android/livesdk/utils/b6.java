package com.bytedance.android.livesdk.utils;

import android.content.Context;
import android.view.OrientationEventListener;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakContainer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakContainer<b> f158892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f158893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f158894c;

    public class a extends OrientationEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f158895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b6 f158896b;

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int r100) {
            if (r100 >= 0) goto L4;
            return;
        L4:
            if (r100 < 360) goto L7;
            return;
        L7:
            if (r100 == (-1)) goto L29;
            this.f158896b.getClass();
            if (r100 > 350) goto L30;
            this.f158896b.getClass();
            if (r100 < 10) goto L30;
            this.f158896b.getClass();
            if (r100 <= 80) goto L19;
            this.f158896b.getClass();
            if (r100 >= 100) goto L19;
            int r101 = 8;
        L32:
            if (this.f158895a != r101) goto L34;
            return;
        L34:
            if (r101 == (-1)) goto L41;
            this.f158895a = r101;
            Iterator<b> r102 = this.f158896b.f158892a.iterator();
        L37:
            if (r102.hasNext() == false) goto L43;
            r102.next().a(r101);
            goto L37
        L43:
            return;
        L41:
            return;
        L19:
            this.f158896b.getClass();
            if (r100 <= 170) goto L24;
            this.f158896b.getClass();
            if (r100 >= 190) goto L24;
            r101 = 9;
        L24:
            this.f158896b.getClass();
            if (r100 <= 260) goto L29;
            this.f158896b.getClass();
            if (r100 >= 280) goto L29;
            r101 = 0;
        L30:
            r101 = 1;
        L29:
            r101 = -1;
            goto L32
        }

        public a(b6 r100, Context r101) {
            this.f158896b = r100;
            super(r101);
            this.f158895a = -1;
        }
    }

    public interface b {
        void a(int r100);
    }

    public b6(Context r100) {
        this.f158892a = new WeakContainer();
        this.f158893b = new a(this, r100.getApplicationContext());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.throwException(e);
    }
}
