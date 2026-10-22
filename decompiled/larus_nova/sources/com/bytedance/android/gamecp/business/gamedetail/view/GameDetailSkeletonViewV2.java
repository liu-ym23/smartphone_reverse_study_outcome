package com.bytedance.android.gamecp.business.gamedetail.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.gamecp.common.utils.y0;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/GameDetailSkeletonViewV2;", "Landroid/view/View;", "", "start", "", "setBgTopStart", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameDetailSkeletonViewV2 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f55677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f55678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f55679c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f55680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f55681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f55682c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f55683d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f55684e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f55685f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f55686g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L20;
            a r101 = (a) r100;
            if (this.f55680a == r101.f55680a) goto L8;
            return false;
        L8:
            if (Float.compare(this.f55681b, r101.f55681b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.f55682c, r101.f55682c) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f55683d, r101.f55683d) == 0) goto L14;
            return false;
        L14:
            if (Float.compare(this.f55684e, r101.f55684e) == 0) goto L16;
            return false;
        L16:
            if (Float.compare(this.f55685f, r101.f55685f) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f55686g, r101.f55686g) == 0) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            return (((((((((((this.f55680a * 31) + Float.floatToIntBits(this.f55681b)) * 31) + Float.floatToIntBits(this.f55682c)) * 31) + Float.floatToIntBits(this.f55683d)) * 31) + Float.floatToIntBits(this.f55684e)) * 31) + Float.floatToIntBits(this.f55685f)) * 31) + Float.floatToIntBits(this.f55686g);
        }

        public final String toString() {
            return "SkeletonItem(color=" + this.f55680a + ", left=" + this.f55681b + ", top=" + this.f55682c + ", right=" + this.f55683d + ", bottom=" + this.f55684e + ", rx=" + this.f55685f + ", ry=" + this.f55686g + ")";
        }

        public a(int r100, float r101, float r102, float r103, float r104, float r105, float r106) {
            this.f55680a = r100;
            this.f55681b = r101;
            this.f55682c = r102;
            this.f55683d = r103;
            this.f55684e = r104;
            this.f55685f = r105;
            this.f55686g = r106;
        }
    }

    public GameDetailSkeletonViewV2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GameDetailSkeletonViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setBgTopStart(int r100) {
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        Iterator<a> r101 = this.f55677a.iterator();     // Catch: Throwable -> L9
    L5:
        if (r101.hasNext() == false) goto L7;
        a r102 = r101.next();     // Catch: Throwable -> L9
        this.f55678b.setColor(r102.f55680a);     // Catch: Throwable -> L9
        r110.drawRoundRect(r102.f55681b, r102.f55682c, r102.f55683d, r102.f55684e, r102.f55685f, r102.f55686g, this.f55678b);     // Catch: Throwable -> L9
        goto L5
    L7:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public GameDetailSkeletonViewV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f55677a = new ArrayList();
        Paint r103 = new Paint();
        r103.setStyle(Paint.Style.FILL);
        Unit r104 = Unit.INSTANCE;
        this.f55678b = r103;
        this.f55679c = y0.a(1.0f);
    }

    public /* synthetic */ GameDetailSkeletonViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r210, int r310, int r311, int r312) {
        super.onSizeChanged(r210, r310, r311, r312);
        this.f55677a.clear();
        float r100 = 12;
        float r101 = this.f55679c;
        float r110 = r100 * r101;
        float r111 = 8;
        float r112 = r111 * r101;
        int r113 = (int) BodyPartID.bodyIdMax;
        float r114 = r210;
        float r102 = 18;
        float r115 = r102 * r101;
        float r116 = r114 - r115;
        float r117 = 280 * r101;
        float r103 = r117 + (123 * r101);
        this.f55677a.add(new a(r113, 0.0f, r117, r114, r103, r110, r110));
        float r104 = this.f55679c;
        float r118 = r117 + (r102 * r104);
        float r119 = 64;
        float r105 = r104 * r119;
        this.f55677a.add(new a(219551779, r115, r118, r115 + r105, r118 + r105, r112, r112));
        float r106 = this.f55679c;
        float r120 = (r115 + (r119 * r106)) + (r111 * r106);
        float r121 = 22;
        float r122 = r118 + (r106 * r121);
        this.f55677a.add(new a(219551779, r120, r118, r116, r122, r112, r112));
        float r123 = 7;
        float r107 = this.f55679c;
        float r108 = r122 + (r123 * r107);
        float r124 = 14;
        float r125 = r108 + (r107 * r124);
        this.f55677a.add(new a(219551779, r120, r108, r116, r125, r112, r112));
        float r109 = this.f55679c;
        float r126 = r125 + (r123 * r109);
        float r127 = r126 + (r124 * r109);
        this.f55677a.add(new a(219551779, r120, r126, r116, r127, r112, r112));
        float r128 = this.f55679c;
        float r129 = r127 + (15 * r128);
        this.f55677a.add(new a(219551779, r115, r129, r116, r129 + (r124 * r128), r112, r112));
        float r130 = this.f55679c;
        float r131 = r103 + (r111 * r130);
        this.f55677a.add(new a(r113, 0.0f, r131, r114, r131 + (MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND * r130), r110, r110));
        float r132 = this.f55679c;
        float r133 = r131 + (r100 * r132);
        float r134 = (24 * r132) + r133;
        this.f55677a.add(new a(219551779, r115, r133, r116, r134, r112, r112));
        float r135 = this.f55679c;
        float r136 = r134 + (20 * r135);
        float r137 = (114 * r135) + r136;
        this.f55677a.add(new a(219551779, r115, r136, r116, r137, r112, r112));
        float r138 = this.f55679c;
        float r139 = r137 + (32 * r138);
        float r140 = r139 + (r121 * r138);
        this.f55677a.add(new a(219551779, r115, r139, r116, r140, r112, r112));
        float r141 = this.f55679c;
        float r142 = r140 + (16 * r141);
        this.f55677a.add(new a(219551779, r115, r142, r116, r142 + (141 * r141), r112, r112));
    }
}
