package D2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;

/* loaded from: classes.dex */
public class w implements i<String, Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final LruCache<String, Drawable> f1198a = new a(8388608);

    class a extends LruCache<String, Drawable> {
        a(int i5) {
            super(i5);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Drawable drawable) {
            return w.c(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(Drawable drawable) {
        Bitmap bitmap;
        if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            return Math.max(bitmap.getAllocationByteCount(), 1);
        }
        int intrinsicWidth = drawable == null ? 0 : drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return 1;
        }
        return intrinsicWidth * intrinsicHeight * 4;
    }

    @Override // D2.i
    public void a() {
        this.f1198a.evictAll();
    }

    @Override // D2.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Drawable get(String str) {
        return this.f1198a.get(str);
    }

    @Override // D2.i
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Drawable put(String str, Drawable drawable) {
        return this.f1198a.put(str, drawable);
    }
}
