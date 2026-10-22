package e;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends a<Intent, ActivityResult> {
    @Override // e.a
    public final Intent a(Context context, Intent intent) {
        Intent input = intent;
        g.f(input, "input");
        return input;
    }

    @Override // e.a
    public final ActivityResult c(int i10, Intent intent) {
        return new ActivityResult(i10, intent);
    }
}
