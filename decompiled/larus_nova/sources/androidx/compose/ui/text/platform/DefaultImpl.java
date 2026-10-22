package androidx.compose.ui.text.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.emoji2.text.EmojiCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/platform/DefaultImpl;", "Landroidx/compose/ui/text/platform/EmojiCompatStatusDelegate;", "<init>", "()V", "loadState", "Landroidx/compose/runtime/State;", "", "fontLoaded", "getFontLoaded", "()Landroidx/compose/runtime/State;", "getFontLoadState", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultImpl implements EmojiCompatStatusDelegate {
    private State<Boolean> loadState;

    @Override // androidx.compose.ui.text.platform.EmojiCompatStatusDelegate
    public State<Boolean> getFontLoaded() {
        State<Boolean> r100 = this.loadState;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        return r100;
    L6:
        if (EmojiCompat.isConfigured() == false) goto L9;
        State<Boolean> r101 = getFontLoadState();
        this.loadState = r101;
        Intrinsics.checkNotNull(r101);
        return r101;
    L9:
        return EmojiCompatStatus_androidKt.access$getFalsey$p();
    }

    public DefaultImpl() {
        if (EmojiCompat.isConfigured() == false) goto L5;
        State<Boolean> r100 = getFontLoadState();
    L6:
        this.loadState = r100;
        return;
    L5:
        r100 = null;
        goto L6
    }

    private final State<Boolean> getFontLoadState() {
        EmojiCompat r100 = EmojiCompat.get();
        if (r100.getLoadState() == 1) goto L7;
        final MutableState r101 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r100.registerInitCallback(new DefaultImpl$getFontLoadState$initCallback$1(r101, this));
        return r101;
    L7:
        return new ImmutableBool(true);
    }

    public static final /* synthetic */ void access$setLoadState$p(DefaultImpl r100, State r101) {
        r100.loadState = r101;
    }
}
