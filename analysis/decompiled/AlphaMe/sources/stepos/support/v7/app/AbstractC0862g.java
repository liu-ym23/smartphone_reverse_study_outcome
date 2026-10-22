package stepos.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.widget.Button;
import androidx.appcompat.app.HandlerC0183i;
import com.stepos.alphame.R;
import java.util.ArrayList;

/* renamed from: stepos.support.v7.app.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0862g {

    /* renamed from: a, reason: collision with root package name */
    public final int f14472a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14473b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14474c;

    public AbstractC0862g(Context context, A a4) {
        new HandlerC0183i(a4, 1);
        new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, I3.a.f842b, R.attr.alertDialogStyle, 0);
        typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.f14472a = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        typedArrayObtainStyledAttributes.getResourceId(6, 0);
        this.f14473b = typedArrayObtainStyledAttributes.getResourceId(11, 0);
        this.f14474c = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(7, 0);
        typedArrayObtainStyledAttributes.getResourceId(8, 0);
        typedArrayObtainStyledAttributes.getResourceId(9, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(14, 0);
        typedArrayObtainStyledAttributes.recycle();
        a4.supportRequestWindowFeature(1);
    }

    public abstract Button a(int i4);

    public abstract void b(int i4, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable);

    public abstract void c(int i4);

    public abstract void d(Drawable drawable);
}
