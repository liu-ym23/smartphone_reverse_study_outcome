package com.bytedance.android.ec.store.view;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.core.graphics.ColorUtils;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class q extends SpannableString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<a> f48955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<ForegroundColorSpan> f48956b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f48957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f48959c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f48960d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f48961e;

        public a(int r100, int r101, int r102) {
            this.f48957a = 0;
            this.f48958b = r100;
            this.f48959c = 33;
            this.f48960d = r101;
            this.f48961e = r102;
        }
    }

    public q(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "sequence");
        super(r100);
        this.f48955a = new LinkedList();
        this.f48956b = new LinkedList();
    }

    public final void a(float r100) {
        Iterator<T> r101 = this.f48956b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        removeSpan((ForegroundColorSpan) r101.next());
        goto L4
    L6:
        this.f48956b.clear();
        Iterator<T> r102 = this.f48955a.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        a r103 = (a) r102.next();
        ForegroundColorSpan r104 = new ForegroundColorSpan(ColorUtils.blendARGB(r103.f48960d, r103.f48961e, r100));
        this.f48956b.add(r104);
        Unit r105 = Unit.INSTANCE;
        setSpan(r104, r103.f48957a, r103.f48958b, r103.f48959c);
        goto L8
    }
}
