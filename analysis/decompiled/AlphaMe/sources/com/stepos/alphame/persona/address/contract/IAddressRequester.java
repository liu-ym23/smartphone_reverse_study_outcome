package com.stepos.alphame.persona.address.contract;

import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.persona.address.data.AddressEntity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005H&¨\u0006\u0014"}, d2 = {"Lcom/stepos/alphame/persona/address/contract/IAddressRequester;", "", "requestAddressTipsWhenShowMainPage", "", "currentAddressEntity", "Lcom/stepos/alphame/persona/address/data/AddressEntity;", "isSelectedAddress", "", "isCacheCurrentAddress", "requestAddressTipsWhenShowSearchPage", "tip", "", "requestCacheCurrentLocation", "requestCurrentLocation", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "requestData", "requestHistoricalAddressRecords", "updateHistoricalAddressRecords", "selectedAddressEntity", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface IAddressRequester {
    void requestAddressTipsWhenShowMainPage(@Nullable AddressEntity currentAddressEntity, boolean isSelectedAddress, boolean isCacheCurrentAddress);

    void requestAddressTipsWhenShowSearchPage(@NotNull String tip);

    void requestCacheCurrentLocation();

    void requestCurrentLocation(@NotNull Context context);

    void requestData(@NotNull Context context);

    void requestHistoricalAddressRecords(@NotNull Context context);

    void updateHistoricalAddressRecords(@NotNull Context context, @NotNull AddressEntity selectedAddressEntity);
}
