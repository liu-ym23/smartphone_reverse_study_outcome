package androidx.compose.ui.text.style;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¨\u0006\t"}, d2 = {"packBytes", "", "i1", "i2", "i3", "unpackByte1", BuyNowCloseMethod.MASK, "unpackByte2", "unpackByte3", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LineBreak_androidKt {
    private static final int packBytes(int r100, int r101, int r102) {
        return (r100 | (r101 << 8)) | (r102 << 16);
    }

    private static final int unpackByte1(int r100) {
        return r100 & 255;
    }

    private static final int unpackByte2(int r100) {
        return (r100 >> 8) & 255;
    }

    private static final int unpackByte3(int r100) {
        return (r100 >> 16) & 255;
    }

    public static final /* synthetic */ int access$unpackByte1(int r100) {
        return unpackByte1(r100);
    }

    public static final /* synthetic */ int access$unpackByte2(int r100) {
        return unpackByte2(r100);
    }

    public static final /* synthetic */ int access$unpackByte3(int r100) {
        return unpackByte3(r100);
    }

    public static final /* synthetic */ int access$packBytes(int r100, int r101, int r102) {
        return packBytes(r100, r101, r102);
    }
}
