package androidx.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Args", "Landroidx/navigation/NavArgs;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class ActivityNavArgsLazyKt$navArgs$1 extends Lambda implements Function0<Bundle> {
    final /* synthetic */ Activity $this_navArgs;

    public ActivityNavArgsLazyKt$navArgs$1(Activity r10) {
        this.$this_navArgs = r10;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Bundle invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Bundle invoke() {
        Intent r10 = this.$this_navArgs.getIntent();
        if (r10 == null) goto L9;
        Activity r11 = this.$this_navArgs;
        Bundle r12 = r10.getExtras();
        if (r12 == null) goto L8;
    L10:
        if (r12 == null) goto L13;
        return r12;
    L13:
        throw new IllegalStateException("Activity " + this.$this_navArgs + " has a null Intent");
    L8:
        throw new IllegalStateException("Activity " + r11 + " has null extras in " + r10);
    L9:
        r12 = null;
        goto L10
    }
}
