package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public class TypefaceEmojiRasterizer {
    static final int HAS_GLYPH_ABSENT = 1;
    static final int HAS_GLYPH_EXISTS = 2;
    static final int HAS_GLYPH_UNKNOWN = 0;
    private static final ThreadLocal<MetadataItem> sMetadataItem = null;
    private volatile int mCache;
    private final int mIndex;
    private final MetadataRepo mMetadataRepo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }

    static {
        sMetadataItem = new ThreadLocal();
    }

    private MetadataItem getMetadataItem() {
        ThreadLocal<MetadataItem> r100 = sMetadataItem;
        MetadataItem r101 = r100.get();
        if (r101 != null) goto L5;
        r101 = new MetadataItem();
        r100.set(r101);
    L5:
        this.mMetadataRepo.getMetadataList().list(r101, this.mIndex);
        return r101;
    }

    public int getHasGlyph() {
        return this.mCache & 3;
    }

    public Typeface getTypeface() {
        return this.mMetadataRepo.getTypeface();
    }

    public boolean isPreferredSystemRender() {
        if ((this.mCache & 4) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(super.toString());
        r100.append(", id:");
        r100.append(Integer.toHexString(getId()));
        r100.append(", codepoints:");
        int r101 = getCodepointsLength();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        r100.append(Integer.toHexString(getCodepointAt(r102)));
        r100.append(" ");
        r102 = r102 + 1;
        goto L3
    L6:
        return r100.toString();
    }

    public int getCodepointsLength() {
        return getMetadataItem().codepointsLength();
    }

    public short getCompatAdded() {
        return getMetadataItem().compatAdded();
    }

    public int getHeight() {
        return getMetadataItem().height();
    }

    public int getId() {
        return getMetadataItem().id();
    }

    public short getSdkAdded() {
        return getMetadataItem().sdkAdded();
    }

    public int getWidth() {
        return getMetadataItem().width();
    }

    public boolean isDefaultEmoji() {
        return getMetadataItem().emojiStyle();
    }

    public void resetHasGlyphCache() {
        if (isPreferredSystemRender() == false) goto L5;
        this.mCache = 4;
        return;
    L5:
        this.mCache = 0;
    }

    public int getCodepointAt(int r100) {
        return getMetadataItem().codepoints(r100);
    }

    public void setExclusion(boolean r100) {
        int r101 = getHasGlyph();
        if (r100 == false) goto L5;
        this.mCache = r101 | 4;
        return;
    L5:
        this.mCache = r101;
    }

    public void setHasGlyph(boolean r100) {
        int r101 = this.mCache & 4;
        if (r100 == false) goto L5;
        int r102 = r101 | 2;
    L6:
        this.mCache = r102;
        return;
    L5:
        r102 = r101 | 1;
        goto L6
    }

    public TypefaceEmojiRasterizer(MetadataRepo r100, int r101) {
        this.mCache = 0;
        this.mMetadataRepo = r100;
        this.mIndex = r101;
    }

    public void draw(Canvas r110, float r111, float r112, Paint r113) {
        Typeface r100 = this.mMetadataRepo.getTypeface();
        Typeface r101 = r113.getTypeface();
        r113.setTypeface(r100);
        int r102 = this.mIndex * 2;
        r110.drawText(this.mMetadataRepo.getEmojiCharArray(), r102, 2, r111, r112, r113);
        r113.setTypeface(r101);
    }
}
