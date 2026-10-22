package avc;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.TextView;

/* JADX INFO: loaded from: classes42.dex */
public class c extends TextView implements xuc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16400b;

    public void c(int r100, int r101, float r102, boolean r103) {
    }

    public void d(int r100, int r101, float r102, boolean r103) {
    }

    @Override // xuc.b
    public int getContentLeft() {
        Rect r100 = new Rect();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), r100);
        int r101 = r100.width();
        return (getLeft() + (getWidth() / 2)) - (r101 / 2);
    }

    @Override // xuc.b
    public int getContentRight() {
        Rect r100 = new Rect();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), r100);
        int r101 = r100.width();
        return (getLeft() + (getWidth() / 2)) + (r101 / 2);
    }

    @Override // xuc.b
    public int getContentBottom() {
        Paint.FontMetrics r100 = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((r100.bottom - r100.top) / 2.0f));
    }

    @Override // xuc.b
    public int getContentTop() {
        Paint.FontMetrics r100 = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((r100.bottom - r100.top) / 2.0f));
    }

    public int getNormalColor() {
        return this.f16400b;
    }

    public int getSelectedColor() {
        return this.f16399a;
    }

    public c(Context r100) {
        super(r100, null);
        setGravity(17);
        int r101 = vuc.b.a(r100, 10.0d);
        setPadding(r101, 0, r101, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public void setNormalColor(int r100) {
        this.f16400b = r100;
    }

    public void setSelectedColor(int r100) {
        this.f16399a = r100;
    }

    public void a(int r100, int r101) {
        setTextColor(this.f16399a);
    }

    public void b(int r100, int r101) {
        setTextColor(this.f16400b);
    }
}
