package x1;

import android.graphics.Paint;
import android.graphics.Path;
import com.stepos.alphame.utils.Property;

/* renamed from: x1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0980a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f15889i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f15890j = {Property.DEFAULT_FLOAT_VALUE, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f15891k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f15892l = {Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f15893a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f15894b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f15895c;

    /* renamed from: d, reason: collision with root package name */
    public int f15896d;

    /* renamed from: e, reason: collision with root package name */
    public int f15897e;

    /* renamed from: f, reason: collision with root package name */
    public int f15898f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f15899g = new Path();

    /* renamed from: h, reason: collision with root package name */
    public final Paint f15900h;

    public C0980a() {
        Paint paint = new Paint();
        this.f15900h = paint;
        Paint paint2 = new Paint();
        this.f15893a = paint2;
        this.f15896d = D.a.d(-16777216, 68);
        this.f15897e = D.a.d(-16777216, 20);
        this.f15898f = D.a.d(-16777216, 0);
        paint2.setColor(this.f15896d);
        paint.setColor(0);
        Paint paint3 = new Paint(4);
        this.f15894b = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f15895c = new Paint(paint3);
    }
}
