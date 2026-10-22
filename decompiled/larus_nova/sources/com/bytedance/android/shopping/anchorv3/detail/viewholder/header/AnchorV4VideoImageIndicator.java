package com.bytedance.android.shopping.anchorv3.detail.viewholder.header;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import c63.d;
import c63.e;
import c63.f;
import com.bytedance.android.ec.model.ECUrlModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0007\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/header/AnchorV4VideoImageIndicator;", "Landroid/widget/LinearLayout;", "Lc63/a;", "Lc63/e;", "listener", "", "setOnIndicatorSelectedListener", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4VideoImageIndicator extends LinearLayout implements c63.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f164821d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f164822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f164823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f164824c;

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<f63.a> f164825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f164826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f164827c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f164828d;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f164825a, r101.f164825a) == true) goto L8;
            return false;
        L8:
            if (this.f164826b == r101.f164826b) goto L10;
            return false;
        L10:
            if (this.f164827c == r101.f164827c) goto L12;
            return false;
        L12:
            if (this.f164828d == r101.f164828d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public final int hashCode() {
            List<f63.a> r100 = this.f164825a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = ((r101 * 31) + this.f164826b) * 31;
            boolean r103 = this.f164827c;
            ?? r104 = r103;
            if (r103 == false) goto L10;
            r104 = 1;
        L10:
            return ((r102 + r104) * 31) + this.f164828d;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "IndicatorState(groupImages=" + this.f164825a + ", videoCount=" + this.f164826b + ", expanded=" + this.f164827c + ", lastIndex=" + this.f164828d + ")";
        }

        public /* synthetic */ b(int r100) {
            this(CollectionsKt.emptyList(), 0, false, 0);
        }

        public b(List<f63.a> r100, int r101, boolean r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "groupImages");
            this.f164825a = r100;
            this.f164826b = r101;
            this.f164827c = r102;
            this.f164828d = r103;
        }
    }

    public AnchorV4VideoImageIndicator(Context r100) {
        this(r100, null, 0, 30);
    }

    public AnchorV4VideoImageIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 28);
    }

    public AnchorV4VideoImageIndicator(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 24);
    }

    @Override // c63.a
    public void setOnIndicatorSelectedListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    static {
        f164821d = new a();
        new ECUrlModel();
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.h
    public final void a(int r100) {
        b(r100 + this.f164823b.f164826b);
    }

    public final void b(int r100) {
        Iterator r101 = ((ArrayList) this.f164822a).iterator();
        int r102 = r100;
    L4:
        if (r101.hasNext() == false) goto L9;
        f r103 = (f) r101.next();
        r103.getClass();
        if (r102 < 0) goto L10;
        r102 = r102 + 0;
    L10:
        if (r103 == null) goto L18;
        boolean r104 = r103.f22587a;
        d r105 = this.f164824c;
        if (r105 == null) goto L17;
        if (r104 == false) goto L15;
        String r106 = "click";
    L16:
        d.a.a(r105, r106, r103.getType(), null, 12);
        goto L17
    L15:
        r106 = "draw";
    L17:
        r103.f22587a = false;
    L19:
        Iterator r107 = ((ArrayList) this.f164822a).iterator();
        if (r107.hasNext() == true) goto L23;
        b r108 = this.f164823b;
        List<f63.a> r109 = r108.f164825a;
        int r110 = r108.f164826b;
        boolean r111 = r108.f164827c;
        Intrinsics.checkNotNullParameter(r109, "groupImages");
        this.f164823b = new b(r109, r110, r111, r100);
        return;
    L23:
        f r112 = (f) r107.next();
        r112.getClass();
        Intrinsics.areEqual(r103, r112);
        throw null;
    L18:
        r103 = null;
        goto L19
    L9:
        r103 = null;
        goto L10
    }

    public AnchorV4VideoImageIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r101 = null;
    L5:
        int r104 = 0;
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f164824c = null;
        this.f164822a = new ArrayList();
        this.f164823b = new b(r104);
        setBackgroundResource(R.drawable.commerce_bg_indicator_container_v4);
    }
}
