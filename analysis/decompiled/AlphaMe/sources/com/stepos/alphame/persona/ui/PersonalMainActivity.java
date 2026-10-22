package com.stepos.alphame.persona.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.C0279a;
import androidx.fragment.app.Y;
import com.baidu.platform.comapi.map.MapController;
import com.stepos.alphame.R;
import com.stepos.alphame.persona.information_used.ui.PersonalInfoAuthorizationActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/alphame/persona/ui/PersonalMainActivity;", "Lcom/stepos/architecture/ui/stepos/b;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", MapController.ITEM_LAYER_TAG, "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "initViewModel", "()V", "<init>", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class PersonalMainActivity extends com.stepos.architecture.ui.stepos.b {
    @Override // com.stepos.architecture.ui.stepos.b
    public void initViewModel() {
    }

    @Override // com.stepos.architecture.ui.stepos.b, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getTheme().applyStyle(R.style.Preference_Immersive, true);
        setContentView(R.layout.activity_fragment);
        setActionBarTitle(R.string.aicy_personal_info);
        Y supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        C0279a c0279a = new C0279a(supportFragmentManager);
        c0279a.g(new PersonalMainFragment(), R.id.fragment_container);
        c0279a.d(false);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@Nullable Menu menu) {
        getMenuInflater().inflate(R.menu.personal_preference_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.stepos.architecture.ui.stepos.b, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != R.id.setting_add) {
            return super.onOptionsItemSelected(item);
        }
        PersonalInfoAuthorizationActivity.INSTANCE.start(this);
        return true;
    }
}
