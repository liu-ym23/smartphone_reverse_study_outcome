package androidx.compose.ui.text.android;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ(\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/android/HorizontalPositionCache;", "", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "<init>", "(Landroidx/compose/ui/text/android/TextLayout;)V", "getLayout", "()Landroidx/compose/ui/text/android/TextLayout;", "cachedKey", "", "cachedValue", "", "getPrimaryDownstream", "offset", "getPrimaryUpstream", "getSecondaryDownstream", "getSecondaryUpstream", MonitorConstants.CONNECT_TYPE_GET, "upstream", "", "cache", "primary", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class HorizontalPositionCache {
    private int cachedKey;
    private float cachedValue;
    private final TextLayout layout;

    public final TextLayout getLayout() {
        return this.layout;
    }

    public HorizontalPositionCache(TextLayout r100) {
        this.layout = r100;
        this.cachedKey = -1;
    }

    public final float getPrimaryDownstream(int r100) {
        return get(r100, false, false, true);
    }

    public final float getPrimaryUpstream(int r100) {
        return get(r100, true, true, true);
    }

    public final float getSecondaryDownstream(int r100) {
        return get(r100, false, false, false);
    }

    public final float getSecondaryUpstream(int r100) {
        return get(r100, true, true, false);
    }

    private final float get(int r100, boolean r101, boolean r102, boolean r103) {
        int r104 = 1;
        if (r101 == false) goto L8;
        int r105 = LayoutCompat_androidKt.getLineForOffset(this.layout.getLayout(), r100, r101);
        int r106 = this.layout.getLineStart(r105);
        int r107 = this.layout.getLineEnd(r105);
        if (r100 == r106) goto L7;
        if (r100 != r107) goto L8;
    L7:
        boolean r108 = true;
    L9:
        int r109 = r100 * 4;
        if (r103 == false) goto L13;
        if (r108 == false) goto L16;
        r104 = 0;
    L16:
        int r110 = r109 + r104;
        if (this.cachedKey == r110) goto L19;
        if (r103 == false) goto L22;
        float r111 = this.layout.getPrimaryHorizontal(r100, r101);
    L23:
        if (r102 == false) goto L25;
        this.cachedKey = r110;
        this.cachedValue = r111;
    L25:
        return r111;
    L22:
        r111 = this.layout.getSecondaryHorizontal(r100, r101);
        goto L23
    L19:
        return this.cachedValue;
    L13:
        if (r108 == false) goto L15;
        r104 = 2;
        goto L16
    L15:
        r104 = 3;
    L8:
        r108 = false;
        goto L9
    }
}
