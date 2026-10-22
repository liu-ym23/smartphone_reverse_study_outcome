package u4;

import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.stepos.aiengine.R;
import com.stepos.backend.onnx.SmsParseCpuModel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a<V extends View> {

    /* renamed from: a, reason: collision with root package name */
    public final PathInterpolator f13143a = new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);

    /* renamed from: b, reason: collision with root package name */
    public final V f13144b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13145c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13146d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13147e;

    /* renamed from: f, reason: collision with root package name */
    public b.a f13148f;

    public a(V v3) {
        this.f13144b = v3;
        Context context = v3.getContext();
        this.f13145c = j.c(context, R.attr.motionDurationMedium2, 300);
        this.f13146d = j.c(context, R.attr.motionDurationShort3, SmsParseCpuModel.MAX_SEQ_LEN);
        this.f13147e = j.c(context, R.attr.motionDurationShort2, 100);
    }
}
