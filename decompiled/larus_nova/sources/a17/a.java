package a17;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.bytedance.lynx.service.text.TextResourceLoader;
import com.lynx.textra.BBufferInputStream;
import com.lynx.textra.JavaCanvasHelper;
import com.lynx.textra.JavaFontManager;
import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends JavaCanvasHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Canvas f1380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable.Callback f1381b;

    public a(JavaFontManager r100) {
        super(r100);
    }

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void drawRunDelegate(BBufferInputStream r100) throws IOException {
        int r101 = r100.readInt();
        float r102 = r100.readFloat();
        float r103 = r100.readFloat();
        float r104 = r100.readFloat();
        float r105 = r100.readFloat();
        r100.readFloat();
        TextResourceLoader.DrawImage(r101, this.f1380a, r102, r103, r104, r105, this.f1381b);
    }

    public void update(Canvas r100, Drawable.Callback r101) {
        this.f1380a = r100;
        this.f1381b = r101;
    }
}
