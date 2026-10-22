package android.content.res;

import android.graphics.drawable.Drawable;
import com.bytedance.mira.MiraManager;

/* JADX INFO: loaded from: classes2.dex */
public class TypedArrayWrapper extends TypedArray {
    public TypedArrayWrapper(Resources r100) {
        super(r100);
    }

    @Override // android.content.res.TypedArray
    public Drawable getDrawable(int r100) {
        Drawable r101 = super.getDrawable(r100);
        MiraManager.getInstance().getParam().getResourceIdVisitor();
        return r101;
    }
}
