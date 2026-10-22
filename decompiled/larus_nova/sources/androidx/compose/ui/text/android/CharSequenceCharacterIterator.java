package androidx.compose.ui.text.android;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import java.text.CharacterIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\t\u0010\u000f\u001a\u00020\fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/android/CharSequenceCharacterIterator;", "Ljava/lang/Object;", "Ljava/text/CharacterIterator;", "charSequence", "", "start", "", "end", "<init>", "(Ljava/lang/CharSequence;II)V", "index", SoloKtvContext.SOLO_PAGE_FIRST, "", "last", "current", TeaEventTrack.ACTION_DRAMA_NEXT, "previous", "setIndex", "position", "getBeginIndex", "getEndIndex", "getIndex", "clone", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CharSequenceCharacterIterator implements CharacterIterator {
    public static final int $stable = 8;
    private final CharSequence charSequence;
    private final int end;
    private int index;
    private final int start;

    @Override // java.text.CharacterIterator
    public char current() {
        int r100 = this.index;
        if (r100 != this.end) goto L6;
        return CharCompanionObject.MAX_VALUE;
    L6:
        return this.charSequence.charAt(r100);
    }

    @Override // java.text.CharacterIterator
    public char first() {
        this.index = this.start;
        return current();
    }

    @Override // java.text.CharacterIterator
    public char last() {
        int r100 = this.start;
        int r101 = this.end;
        if (r100 != r101) goto L5;
        this.index = r101;
        return CharCompanionObject.MAX_VALUE;
    L5:
        int r102 = r101 - 1;
        this.index = r102;
        return this.charSequence.charAt(r102);
    }

    @Override // java.text.CharacterIterator
    public char next() {
        int r100 = this.index + 1;
        this.index = r100;
        int r101 = this.end;
        if (r100 < r101) goto L6;
        this.index = r101;
        return CharCompanionObject.MAX_VALUE;
    L6:
        return this.charSequence.charAt(r100);
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        int r100 = this.index;
        if (r100 > this.start) goto L5;
        return CharCompanionObject.MAX_VALUE;
    L5:
        int r101 = r100 - 1;
        this.index = r101;
        return this.charSequence.charAt(r101);
    }

    @Override // java.text.CharacterIterator
    public Object clone() {
        return super.clone();
    L5:
        throw new InternalError();
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return this.start;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.end;
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.index;
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int r100) {
        int r101 = this.start;
        boolean r102 = false;
        if (r100 > this.end) goto L6;
        if (r101 > r100) goto L6;
        r102 = true;
    L6:
        if (r102 == false) goto L10;
        this.index = r100;
        return current();
    L10:
        throw new IllegalArgumentException("invalid position");
    }

    public CharSequenceCharacterIterator(CharSequence r100, int r101, int r102) {
        this.charSequence = r100;
        this.start = r101;
        this.end = r102;
        this.index = r101;
    }
}
