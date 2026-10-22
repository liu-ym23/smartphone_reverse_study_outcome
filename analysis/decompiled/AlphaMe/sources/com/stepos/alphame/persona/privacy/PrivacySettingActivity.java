package com.stepos.alphame.persona.privacy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.C0279a;
import androidx.fragment.app.Y;
import androidx.lifecycle.n0;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.R;
import com.stepos.alphame.persona.domain.message.PageMessenger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/stepos/alphame/persona/privacy/PrivacySettingActivity;", "Lcom/stepos/architecture/ui/stepos/b;", "", "initViewModel", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "mMessenger", "Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "getMMessenger", "()Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "setMMessenger", "(Lcom/stepos/alphame/persona/domain/message/PageMessenger;)V", "<init>", "Companion", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class PrivacySettingActivity extends com.stepos.architecture.ui.stepos.b {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public PageMessenger mMessenger;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/alphame/persona/privacy/PrivacySettingActivity$Companion;", "", "()V", "start", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) PrivacySettingActivity.class));
        }
    }

    @NotNull
    public final PageMessenger getMMessenger() {
        PageMessenger pageMessenger = this.mMessenger;
        if (pageMessenger != null) {
            return pageMessenger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMessenger");
        return null;
    }

    @Override // com.stepos.architecture.ui.stepos.b
    public void initViewModel() {
        n0 applicationScopeViewModel = getApplicationScopeViewModel(PageMessenger.class);
        Intrinsics.checkNotNullExpressionValue(applicationScopeViewModel, "getApplicationScopeViewModel(...)");
        setMMessenger((PageMessenger) applicationScopeViewModel);
    }

    @Override // com.stepos.architecture.ui.stepos.b, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getTheme().applyStyle(R.style.Preference_Immersive, true);
        setContentView(R.layout.activity_privacy_setting);
        setActionBarTitle(R.string.privacy_policy);
        Y supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        C0279a c0279a = new C0279a(supportFragmentManager);
        c0279a.g(new PrivacySettingFragment(), R.id.fragment_container);
        c0279a.d(false);
    }

    public final void setMMessenger(@NotNull PageMessenger pageMessenger) {
        Intrinsics.checkNotNullParameter(pageMessenger, "<set-?>");
        this.mMessenger = pageMessenger;
    }
}
