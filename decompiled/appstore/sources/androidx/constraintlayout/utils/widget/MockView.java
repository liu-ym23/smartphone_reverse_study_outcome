package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes.dex */
public class MockView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f2111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f2112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f2113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f2117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2121k;

    public MockView(Context r10) {
        super(r10);
        this.f2111a = new Paint();
        this.f2112b = new Paint();
        this.f2113c = new Paint();
        this.f2114d = true;
        this.f2115e = true;
        this.f2116f = null;
        this.f2117g = new Rect();
        this.f2118h = Color.argb(PrivateKeyType.INVALID, 0, 0, 0);
        this.f2119i = Color.argb(PrivateKeyType.INVALID, 200, 200, 200);
        this.f2120j = Color.argb(PrivateKeyType.INVALID, 50, 50, 50);
        this.f2121k = 4;
        a(r10, null);
    }

    private void a(Context r10, AttributeSet r11) {
        if (r11 == null) goto L26;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.MockView);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L24;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.MockView_mock_label) goto L9;
        this.f2116f = r12.getString(r15);
    L23:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 != R$styleable.MockView_mock_showDiagonals) goto L12;
        this.f2114d = r12.getBoolean(r15, this.f2114d);
        goto L23
    L12:
        if (r15 != R$styleable.MockView_mock_diagonalsColor) goto L15;
        this.f2118h = r12.getColor(r15, this.f2118h);
        goto L23
    L15:
        if (r15 != R$styleable.MockView_mock_labelBackgroundColor) goto L18;
        this.f2120j = r12.getColor(r15, this.f2120j);
        goto L23
    L18:
        if (r15 != R$styleable.MockView_mock_labelColor) goto L21;
        this.f2119i = r12.getColor(r15, this.f2119i);
        goto L23
    L21:
        if (r15 != R$styleable.MockView_mock_showLabel) goto L23;
        this.f2115e = r12.getBoolean(r15, this.f2115e);
        goto L23
    L24:
        r12.recycle();
    L26:
        if (this.f2116f == null) goto L31;
    L28:
        this.f2111a.setColor(this.f2118h);
        this.f2111a.setAntiAlias(true);
        this.f2112b.setColor(this.f2119i);
        this.f2112b.setAntiAlias(true);
        this.f2113c.setColor(this.f2120j);
        this.f2121k = Math.round(this.f2121k * (getResources().getDisplayMetrics().xdpi / 160.0f));
        return;
    L31:
        this.f2116f = r10.getResources().getResourceEntryName(getId());     // Catch: Exception -> L30
        goto L28
    }

    @Override // android.view.View
    public void onDraw(Canvas r11) {
        super.onDraw(r11);
        int r10 = getWidth();
        int r12 = getHeight();
        if (this.f2114d == false) goto L5;
        r10 = r10 - 1;
        r12 = r12 - 1;
        float r13 = r10;
        float r14 = r12;
        r11.drawLine(0.0f, 0.0f, r13, r14, this.f2111a);
        r11.drawLine(0.0f, r14, r13, 0.0f, this.f2111a);
        r11.drawLine(0.0f, 0.0f, r13, 0.0f, this.f2111a);
        r11.drawLine(r13, 0.0f, r13, r14, this.f2111a);
        r11.drawLine(r13, r14, 0.0f, r14, this.f2111a);
        r11.drawLine(0.0f, r14, 0.0f, 0.0f, this.f2111a);
    L5:
        String r15 = this.f2116f;
        if (r15 != null) goto L8;
        return;
    L8:
        if (this.f2115e == false) goto L12;
        this.f2112b.getTextBounds(r15, 0, r15.length(), this.f2117g);
        float r16 = (r10 - this.f2117g.width()) / 2.0f;
        float r17 = ((r12 - this.f2117g.height()) / 2.0f) + this.f2117g.height();
        this.f2117g.offset((int) r16, (int) r17);
        Rect r18 = this.f2117g;
        int r19 = r18.left;
        int r20 = this.f2121k;
        r18.set(r19 - r20, r18.top - r20, r18.right + r20, r18.bottom + r20);
        r11.drawRect(this.f2117g, this.f2113c);
        r11.drawText(this.f2116f, r16, r17, this.f2112b);
        return;
    }

    public MockView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f2111a = new Paint();
        this.f2112b = new Paint();
        this.f2113c = new Paint();
        this.f2114d = true;
        this.f2115e = true;
        this.f2116f = null;
        this.f2117g = new Rect();
        this.f2118h = Color.argb(PrivateKeyType.INVALID, 0, 0, 0);
        this.f2119i = Color.argb(PrivateKeyType.INVALID, 200, 200, 200);
        this.f2120j = Color.argb(PrivateKeyType.INVALID, 50, 50, 50);
        this.f2121k = 4;
        a(r10, r11);
    }

    public MockView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f2111a = new Paint();
        this.f2112b = new Paint();
        this.f2113c = new Paint();
        this.f2114d = true;
        this.f2115e = true;
        this.f2116f = null;
        this.f2117g = new Rect();
        this.f2118h = Color.argb(PrivateKeyType.INVALID, 0, 0, 0);
        this.f2119i = Color.argb(PrivateKeyType.INVALID, 200, 200, 200);
        this.f2120j = Color.argb(PrivateKeyType.INVALID, 50, 50, 50);
        this.f2121k = 4;
        a(r10, r11);
    }
}
