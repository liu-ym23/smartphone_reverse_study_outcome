package com.stepos.alphame.persona.address.ui;

import androidx.lifecycle.V;
import com.stepos.alphame.persona.carbluetooth.CarBluetoothListActivity;
import com.stepos.alphame.persona.domain.event.Messages;
import com.stepos.alphame.persona.ui.PersonalMainFragment;
import com.stepos.alphame.persona.wifi.WifiListActivity;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements V {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11196a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11197b;

    public /* synthetic */ e(int i4, Object obj) {
        this.f11196a = i4;
        this.f11197b = obj;
    }

    @Override // androidx.lifecycle.V
    public final void onChanged(Object obj) {
        int i4 = this.f11196a;
        Object obj2 = this.f11197b;
        switch (i4) {
            case 0:
                AddressMainActivity.observe$lambda$15((AddressMainActivity) obj2, (List) obj);
                break;
            case 1:
                CarBluetoothListActivity.observe$lambda$0((CarBluetoothListActivity) obj2, (List) obj);
                break;
            case 2:
                PersonalMainFragment.observer$lambda$2((PersonalMainFragment) obj2, (Messages) obj);
                break;
            default:
                WifiListActivity.observe$lambda$0((WifiListActivity) obj2, (List) obj);
                break;
        }
    }
}
