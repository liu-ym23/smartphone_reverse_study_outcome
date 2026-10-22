package androidx.compose.foundation.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/text/DeadKeyCombiner;", "", "<init>", "()V", "deadKeyCode", "", "Ljava/lang/Integer;", "consume", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "consume-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeadKeyCombiner {
    public static final int $stable = 8;
    private Integer deadKeyCode;

    public DeadKeyCombiner() {
    }

    /* JADX INFO: renamed from: consume-ZmokQxo, reason: not valid java name */
    public final Integer m1050consumeZmokQxo(KeyEvent r100) {
        int r101 = KeyEvent_androidKt.m5979getUtf16CodePointZmokQxo(r100);
        Integer r102 = null;
        if ((Integer.MIN_VALUE & r101) == 0) goto L6;
        this.deadKeyCode = Integer.valueOf(r101 & Integer.MAX_VALUE);
        return null;
    L6:
        Integer r103 = this.deadKeyCode;
        if (r103 == null) goto L19;
        this.deadKeyCode = null;
        Integer r104 = Integer.valueOf(KeyCharacterMap.getDeadChar(r103.intValue(), r101));
        if (r104.intValue() != 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L14;
        r102 = r104;
    L14:
        if (r102 == null) goto L17;
        r101 = r102.intValue();
    L17:
        return Integer.valueOf(r101);
    L11:
        r105 = false;
        goto L12
    L19:
        return Integer.valueOf(r101);
    }
}
