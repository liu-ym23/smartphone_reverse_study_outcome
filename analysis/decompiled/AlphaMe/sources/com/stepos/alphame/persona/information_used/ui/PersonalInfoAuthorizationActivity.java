package com.stepos.alphame.persona.information_used.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.C0279a;
import androidx.fragment.app.Y;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.R;
import com.stepos.architecture.ui.stepos.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/stepos/alphame/persona/information_used/ui/PersonalInfoAuthorizationActivity;", "Lcom/stepos/architecture/ui/stepos/b;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "initViewModel", "()V", "<init>", "Companion", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class PersonalInfoAuthorizationActivity extends b {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/alphame/persona/information_used/ui/PersonalInfoAuthorizationActivity$Companion;", "", "()V", "start", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) PersonalInfoAuthorizationActivity.class));
        }
    }

    @Override // com.stepos.architecture.ui.stepos.b
    public void initViewModel() {
    }

    @Override // com.stepos.architecture.ui.stepos.b, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getTheme().applyStyle(R.style.Preference_Immersive, true);
        setContentView(R.layout.activity_fragment);
        setActionBarTitle(R.string.app_used_setting);
        Y supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        C0279a c0279a = new C0279a(supportFragmentManager);
        c0279a.g(new PersonalInfoAuthorizationFragment(), R.id.fragment_container);
        c0279a.d(false);
    }
}
