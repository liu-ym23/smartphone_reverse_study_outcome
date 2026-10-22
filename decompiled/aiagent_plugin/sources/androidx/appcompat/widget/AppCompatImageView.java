package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements androidx.core.view.y, androidx.core.widget.l {
    private final a mBackgroundTintHelper;
    private boolean mHasLevel;
    private final h mImageHelper;

    public AppCompatImageView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public AppCompatImageView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public AppCompatImageView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TintContextWrapper.wrap(r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, r5);
        this.mHasLevel = false;
        w.a(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        a r8 = new a(this);
        this.mBackgroundTintHelper = r8;
        r8.a(r7, r5);
        h r9 = new h(this);
        this.mImageHelper = r9;
        r9.a(r7, r5);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r1) {
        h r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r3) {
        h r0 = this.mImageHelper;
        if (r0 == null) goto L8;
        if (r3 == null) goto L8;
        if (this.mHasLevel == true) goto L8;
        r0.a(r3);
    L8:
        super.setImageDrawable(r3);
        h r4 = this.mImageHelper;
        if (r4 == null) goto L14;
        r4.d();
        if (this.mHasLevel == true) goto L15;
        this.mImageHelper.e();
        return;
    L15:
        return;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r1) {
        super.setImageBitmap(r1);
        h r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri r1) {
        super.setImageURI(r1);
        h r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r1) {
        super.setBackgroundResource(r1);
        a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r1) {
        super.setBackgroundDrawable(r1);
        a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // androidx.core.view.y
    public void setSupportBackgroundTintList(ColorStateList r1) {
        a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // androidx.core.view.y
    public ColorStateList getSupportBackgroundTintList() {
        a r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // androidx.core.view.y
    public void setSupportBackgroundTintMode(PorterDuff.Mode r1) {
        a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // androidx.core.view.y
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        a r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList r1) {
        h r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        h r0 = this.mImageHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode r1) {
        h r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        h r0 = this.mImageHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        h r1 = this.mImageHelper;
        if (r1 == null) goto L9;
        r1.d();
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        if (this.mImageHelper.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.hasOverlappingRendering() == false) goto L7;
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int r1) {
        super.setImageLevel(r1);
        this.mHasLevel = true;
    }
}
