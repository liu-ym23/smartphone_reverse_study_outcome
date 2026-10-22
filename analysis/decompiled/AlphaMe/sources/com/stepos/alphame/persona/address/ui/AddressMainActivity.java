package com.stepos.alphame.persona.address.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import androidx.lifecycle.n0;
import ch.qos.logback.core.CoreConstants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.platform.comapi.map.MapController;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC0430i;
import com.stepos.alphame.R;
import com.stepos.alphame.databinding.ActivityAddressMainBinding;
import com.stepos.alphame.location.LocationManager;
import com.stepos.alphame.location.MapLocationClient;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.alphame.persona.address.data.AddressEntity;
import com.stepos.alphame.persona.address.data.AddressInfo;
import com.stepos.alphame.persona.address.data.AddressPage;
import com.stepos.alphame.persona.address.domain.AddressRequester;
import com.stepos.alphame.persona.data.PersonalDataType;
import com.stepos.alphame.persona.domain.event.AddressMessages;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.persona.domain.message.PageMessenger;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.ViewKt;
import com.stepos.common.widget.SearchEditText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stepos.support.v7.app.G;
import stepos.support.v7.widget.StepOSRecyclerView;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 g2\u00020\u00012\u00020\u0002:\u0001gB\u0007¢\u0006\u0004\bf\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000e\u0010\tJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\tJ\u0017\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\"\u0010\u0007J\u0019\u0010#\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b#\u0010\u0007J\u000f\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010\tJ\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b)\u0010\tJ\u000f\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010\tJ\u000f\u0010+\u001a\u00020\u0005H\u0002¢\u0006\u0004\b+\u0010\tJ\u000f\u0010,\u001a\u00020\u0005H\u0002¢\u0006\u0004\b,\u0010\tJ\u001f\u00101\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J\u001f\u0010:\u001a\u00020\u00052\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u000207H\u0002¢\u0006\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010R\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010XR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010a\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010d¨\u0006h"}, d2 = {"Lcom/stepos/alphame/persona/address/ui/AddressMainActivity;", "Lcom/stepos/architecture/ui/stepos/d;", "Lcom/baidu/mapapi/search/geocode/OnGetGeoCoderResultListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "()V", "onResume", "onPause", "outState", "onSaveInstanceState", "initViewModel", "Lcom/baidu/mapapi/search/geocode/GeoCodeResult;", "result", "onGetGeoCodeResult", "(Lcom/baidu/mapapi/search/geocode/GeoCodeResult;)V", "Lcom/baidu/mapapi/search/geocode/ReverseGeoCodeResult;", "onGetReverseGeoCodeResult", "(Lcom/baidu/mapapi/search/geocode/ReverseGeoCodeResult;)V", "initLocation", "", "eventId", "getTitleResId", "(I)I", "resId", "setToolbar", "(I)V", "Lcom/stepos/alphame/persona/address/data/AddressInfo;", "addressInfo", "sendResultForRequester", "(Lcom/stepos/alphame/persona/address/data/AddressInfo;)V", "setupViews", "setMainPage", "setSearchPage", "Landroid/view/View;", "view", "hideSoftInput", "(Landroid/view/View;)V", "updateUiWhenShowSearchPage", "updateUiWhenShowMainPage", "initMap", "observe", "Lcom/baidu/mapapi/model/LatLng;", "centerPoint", "", "zoom", "updateMarker", "(Lcom/baidu/mapapi/model/LatLng;F)V", "Lcom/stepos/alphame/persona/address/data/AddressEntity;", MapController.ITEM_LAYER_TAG, "updateLocationIcon", "(Lcom/stepos/alphame/persona/address/data/AddressEntity;)V", "", "lng", "lat", "convertToAddress", "(DD)V", "Lcom/stepos/alphame/databinding/ActivityAddressMainBinding;", "_binding", "Lcom/stepos/alphame/databinding/ActivityAddressMainBinding;", "Lcom/stepos/alphame/persona/address/domain/AddressRequester;", "mRequester", "Lcom/stepos/alphame/persona/address/domain/AddressRequester;", "Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "mMessenger", "Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "Lcom/stepos/alphame/persona/address/ui/AddressListAdapter;", "mSearchAdapter", "Lcom/stepos/alphame/persona/address/ui/AddressListAdapter;", "Lcom/stepos/alphame/persona/address/ui/AddressMainListAdapter;", "mMainAdapter", "Lcom/stepos/alphame/persona/address/ui/AddressMainListAdapter;", "Lcom/baidu/mapapi/map/BaiduMap;", "mMap", "Lcom/baidu/mapapi/map/BaiduMap;", "Lcom/stepos/alphame/location/MapLocationClient;", "mLocationClient", "Lcom/stepos/alphame/location/MapLocationClient;", "Lcom/baidu/mapapi/map/Marker;", "mCurrentMarker", "Lcom/baidu/mapapi/map/Marker;", "Lcom/baidu/mapapi/search/geocode/GeoCoder;", "mGeoCoder", "Lcom/baidu/mapapi/search/geocode/GeoCoder;", "mClickPointLatitude", "D", "mClickPointLongitude", "", "mIsCacheLocationRequested", "Z", "mIsMapViewInitialize", "Lcom/baidu/mapapi/map/MapView;", "mMapView", "Lcom/baidu/mapapi/map/MapView;", "mSavedInstanceState", "Landroid/os/Bundle;", "getBinding", "()Lcom/stepos/alphame/databinding/ActivityAddressMainBinding;", "binding", "<init>", "Companion", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class AddressMainActivity extends com.stepos.architecture.ui.stepos.d implements OnGetGeoCoderResultListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_ADDRESS_LOCATION = "ADDRESS_LOCATION";

    @NotNull
    public static final String KEY_ADDRESS_NAME = "ADDRESS_NAME";

    @Nullable
    private ActivityAddressMainBinding _binding;
    private double mClickPointLatitude;
    private double mClickPointLongitude;

    @Nullable
    private Marker mCurrentMarker;
    private GeoCoder mGeoCoder;
    private boolean mIsCacheLocationRequested;
    private boolean mIsMapViewInitialize;
    private MapLocationClient mLocationClient;
    private AddressMainListAdapter mMainAdapter;
    private BaiduMap mMap;

    @Nullable
    private MapView mMapView;
    private PageMessenger mMessenger;
    private AddressRequester mRequester;

    @Nullable
    private Bundle mSavedInstanceState;
    private AddressListAdapter mSearchAdapter;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/alphame/persona/address/ui/AddressMainActivity$Companion;", "", "()V", "KEY_ADDRESS_LOCATION", "", "KEY_ADDRESS_NAME", "start", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "type", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, int type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) AddressMainActivity.class);
            intent.putExtra(PersonalContract.KEY_PAGE, type);
            context.startActivity(intent);
        }
    }

    private final void convertToAddress(double lng, double lat) {
        GeoCoder geoCoder = this.mGeoCoder;
        if (geoCoder == null) {
            return;
        }
        if (geoCoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGeoCoder");
            geoCoder = null;
        }
        geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(new LatLng(lat, lng)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityAddressMainBinding getBinding() {
        ActivityAddressMainBinding activityAddressMainBinding = this._binding;
        Intrinsics.checkNotNull(activityAddressMainBinding);
        return activityAddressMainBinding;
    }

    private final int getTitleResId(int eventId) {
        return eventId == EventId.HOME_ADDRESS.getId() ? R.string.home_address : R.string.company_address;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideSoftInput(View view) {
        Object systemService = getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private final void initLocation() {
        this.mLocationClient = LocationManager.INSTANCE.getINSTANCE().getLocationClient(this);
    }

    private final void initMap() {
    }

    private final void observe() {
        AddressRequester addressRequester = this.mRequester;
        AddressRequester addressRequester2 = null;
        if (addressRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester = null;
        }
        addressRequester.getMainAddressResult().d(this, new e(0, this));
        AddressRequester addressRequester3 = this.mRequester;
        if (addressRequester3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester3 = null;
        }
        addressRequester3.getLocationAddressEntity().d(this, new AddressMainActivity$sam$androidx_lifecycle_Observer$0(new Function1<AddressEntity, Unit>() { // from class: com.stepos.alphame.persona.address.ui.AddressMainActivity.observe.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AddressEntity addressEntity) {
                invoke2(addressEntity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AddressEntity addressEntity) {
                AddressMainActivity.this.updateMarker(new LatLng(addressEntity.getLatitude(), addressEntity.getLongitude()), 17.0f);
                AddressMainActivity addressMainActivity = AddressMainActivity.this;
                Intrinsics.checkNotNull(addressEntity);
                addressMainActivity.updateLocationIcon(addressEntity);
            }
        }));
        AddressRequester addressRequester4 = this.mRequester;
        if (addressRequester4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester4 = null;
        }
        addressRequester4.getSearchAddressResult().d(this, new AddressMainActivity$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends AddressEntity>, Unit>() { // from class: com.stepos.alphame.persona.address.ui.AddressMainActivity.observe.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends AddressEntity> list) {
                invoke2((List<AddressEntity>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<AddressEntity> list) {
                AddressListAdapter addressListAdapter = AddressMainActivity.this.mSearchAdapter;
                if (addressListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSearchAdapter");
                    addressListAdapter = null;
                }
                addressListAdapter.submitList(list);
            }
        }));
        AddressRequester addressRequester5 = this.mRequester;
        if (addressRequester5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            addressRequester2 = addressRequester5;
        }
        addressRequester2.requestData(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observe$lambda$15(AddressMainActivity this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int size = list.size();
        AddressRequester addressRequester = this$0.mRequester;
        AddressMainListAdapter addressMainListAdapter = null;
        if (addressRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester = null;
        }
        AlphaMeLogger.debugLog("Personal", "update ui size " + size + " list " + list + " page " + addressRequester.get_pageId());
        ActivityAddressMainBinding binding = this$0.getBinding();
        ViewKt.visible(binding.addressTitle);
        ViewKt.visible((ViewGroup) binding.mcSearchLayout);
        ViewKt.visible((ViewGroup) binding.mainAddressLayout);
        ViewKt.gone((ViewGroup) binding.loadingViewLayout);
        AddressMainListAdapter addressMainListAdapter2 = this$0.mMainAdapter;
        if (addressMainListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainAdapter");
        } else {
            addressMainListAdapter = addressMainListAdapter2;
        }
        Intrinsics.checkNotNull(list);
        addressMainListAdapter.setData(list);
    }

    private final void sendResultForRequester(AddressInfo addressInfo) {
        Intent intent = new Intent();
        intent.putExtra(KEY_ADDRESS_NAME, addressInfo.getName());
        intent.putExtra(KEY_ADDRESS_LOCATION, addressInfo.getLocation());
        setResult(-1, intent);
    }

    private final void setMainPage(Bundle savedInstanceState) {
        final ActivityAddressMainBinding binding = getBinding();
        StepOSRecyclerView stepOSRecyclerView = binding.mainAddressListview;
        Intrinsics.checkNotNull(stepOSRecyclerView);
        AddressRequester addressRequester = this.mRequester;
        if (addressRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester = null;
        }
        AddressMainListAdapter addressMainListAdapter = new AddressMainListAdapter(stepOSRecyclerView, addressRequester.getAutoLearningState(), new onItemClickListener() { // from class: com.stepos.alphame.persona.address.ui.AddressMainActivity$setMainPage$1$1$1
            @Override // com.stepos.alphame.persona.address.ui.onItemClickListener
            public void itemClick(@NotNull View view, @NotNull AddressEntity item, int position) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(item, "item");
                AlphaMeLogger.debugLog("Personal", "main item click " + item);
                this.this$0.updateMarker(new LatLng(item.getLatitude(), item.getLongitude()), 17.0f);
                this.this$0.updateLocationIcon(item);
            }
        });
        this.mMainAdapter = addressMainListAdapter;
        stepOSRecyclerView.setAdapter(addressMainListAdapter);
        stepOSRecyclerView.setSelector(R.drawable.selector_transient);
        setViewPadding(binding.titleBar);
        SearchEditText searchEditText = binding.mcSearchEdit;
        searchEditText.addTextChangedListener(new TextWatcher() { // from class: com.stepos.alphame.persona.address.ui.AddressMainActivity$setMainPage$1$2$textWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s4) {
                AlphaMeLogger.debugLog("Personal", "afterTextChanged");
                AddressMainActivity addressMainActivity = this.this$0;
                ActivityAddressMainBinding activityAddressMainBinding = binding;
                String strValueOf = String.valueOf(s4);
                AddressRequester addressRequester2 = null;
                if (TextUtils.isEmpty(strValueOf)) {
                    AddressRequester addressRequester3 = addressMainActivity.mRequester;
                    if (addressRequester3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                    } else {
                        addressRequester2 = addressRequester3;
                    }
                    addressRequester2.requestHistoricalAddressRecords(addressMainActivity);
                    return;
                }
                ViewKt.visible(activityAddressMainBinding.mcInputClear);
                AddressRequester addressRequester4 = addressMainActivity.mRequester;
                if (addressRequester4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                } else {
                    addressRequester2 = addressRequester4;
                }
                addressRequester2.requestAddressTipsWhenShowSearchPage(strValueOf);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence s4, int start, int count, int after) {
                AlphaMeLogger.debugLog("Personal", "beforeTextChanged");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence s4, int start, int before, int count) {
                AlphaMeLogger.debugLog("Personal", "onTextChanged");
            }
        });
        searchEditText.setInputType(524288);
        searchEditText.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0430i(3, this));
        final ImageView imageView = binding.mcInputClear;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.alphame.persona.address.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressMainActivity.setMainPage$lambda$9$lambda$7$lambda$6(binding, imageView, this, view);
            }
        });
        binding.btLocation.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.alphame.persona.address.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressMainActivity.setMainPage$lambda$9$lambda$8(this.f11194a, binding, view);
            }
        });
        this.mSavedInstanceState = savedInstanceState;
        initLocation();
        initMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMainPage$lambda$9$lambda$5$lambda$4(AddressMainActivity this$0, View view, boolean z4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlphaMeLogger.debugLog("Personal", "focus " + z4);
        if (z4) {
            this$0.updateUiWhenShowSearchPage();
            AddressRequester addressRequester = this$0.mRequester;
            AddressRequester addressRequester2 = null;
            if (addressRequester == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                addressRequester = null;
            }
            addressRequester.setPageId(AddressPage.SearchPage.getType());
            AddressRequester addressRequester3 = this$0.mRequester;
            if (addressRequester3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            } else {
                addressRequester2 = addressRequester3;
            }
            addressRequester2.requestHistoricalAddressRecords(this$0);
            this$0.mIsCacheLocationRequested = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMainPage$lambda$9$lambda$7$lambda$6(ActivityAddressMainBinding this_apply, ImageView this_apply$1, AddressMainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this_apply$1, "$this_apply$1");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_apply.mcSearchEdit.setText("");
        ViewKt.gone(this_apply$1);
        AddressRequester addressRequester = this$0.mRequester;
        if (addressRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester = null;
        }
        addressRequester.requestHistoricalAddressRecords(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMainPage$lambda$9$lambda$8(AddressMainActivity this$0, ActivityAddressMainBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        view.setBackground(androidx.core.content.a.b(this$0, R.drawable.current_location));
        AddressRequester addressRequester = this$0.mRequester;
        AddressMainListAdapter addressMainListAdapter = null;
        if (addressRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester = null;
        }
        if (addressRequester.getMCurrentAddress() != null) {
            AddressRequester addressRequester2 = this$0.mRequester;
            if (addressRequester2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                addressRequester2 = null;
            }
            AddressEntity currentAddress = addressRequester2.getMCurrentAddress();
            Intrinsics.checkNotNull(currentAddress);
            double latitude = currentAddress.getLatitude();
            AddressRequester addressRequester3 = this$0.mRequester;
            if (addressRequester3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                addressRequester3 = null;
            }
            AddressEntity currentAddress2 = addressRequester3.getMCurrentAddress();
            Intrinsics.checkNotNull(currentAddress2);
            this$0.updateMarker(new LatLng(latitude, currentAddress2.getLongitude()), 17.0f);
            if (this$0.mIsCacheLocationRequested) {
                AddressMainListAdapter addressMainListAdapter2 = this$0.mMainAdapter;
                if (addressMainListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMainAdapter");
                } else {
                    addressMainListAdapter = addressMainListAdapter2;
                }
                addressMainListAdapter.updateItemWhenRequestCurrentLocation();
                this_apply.mainAddressListview.smoothScrollToPosition(0);
                return;
            }
            this$0.mIsCacheLocationRequested = true;
            AddressRequester addressRequester4 = this$0.mRequester;
            if (addressRequester4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                addressRequester4 = null;
            }
            addressRequester4.requestCacheCurrentLocation();
        } else {
            AddressRequester addressRequester5 = this$0.mRequester;
            if (addressRequester5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                addressRequester5 = null;
            }
            addressRequester5.requestCurrentLocation(this$0);
        }
        AddressMainListAdapter addressMainListAdapter3 = this$0.mMainAdapter;
        if (addressMainListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainAdapter");
        } else {
            addressMainListAdapter = addressMainListAdapter3;
        }
        addressMainListAdapter.updateItemWhenRequestCurrentLocation();
        this_apply.mainAddressListview.smoothScrollToPosition(0);
    }

    private final void setSearchPage() {
        StepOSRecyclerView stepOSRecyclerView = getBinding().searchAddressListview;
        AddressListAdapter addressListAdapter = new AddressListAdapter(new onItemClickListener() { // from class: com.stepos.alphame.persona.address.ui.AddressMainActivity$setSearchPage$1$1$1
            @Override // com.stepos.alphame.persona.address.ui.onItemClickListener
            public void itemClick(@NotNull View view, @NotNull AddressEntity item, int position) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(item, "item");
                AlphaMeLogger.debugLog("Personal", "item click again");
                this.this$0.hideSoftInput(view);
                this.this$0.updateUiWhenShowMainPage();
                String name = item.getName();
                AddressRequester addressRequester = this.this$0.mRequester;
                AddressRequester addressRequester2 = null;
                if (addressRequester == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                    addressRequester = null;
                }
                AddressEntity mCurrentAddress = addressRequester.getMCurrentAddress();
                if (Intrinsics.areEqual(name, mCurrentAddress != null ? mCurrentAddress.getName() : null)) {
                    this.this$0.getBinding().btLocation.setBackground(androidx.core.content.a.b(this.this$0, R.drawable.not_current_location));
                } else {
                    this.this$0.getBinding().btLocation.setBackground(androidx.core.content.a.b(this.this$0, R.drawable.current_location));
                }
                AddressRequester addressRequester3 = this.this$0.mRequester;
                if (addressRequester3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                    addressRequester3 = null;
                }
                addressRequester3.requestAddressTipsWhenShowMainPage(item, false, false);
                AddressRequester addressRequester4 = this.this$0.mRequester;
                if (addressRequester4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                    addressRequester4 = null;
                }
                addressRequester4.setPageId(AddressPage.MainPage.getType());
                AddressRequester addressRequester5 = this.this$0.mRequester;
                if (addressRequester5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                } else {
                    addressRequester2 = addressRequester5;
                }
                addressRequester2.updateHistoricalAddressRecords(this.this$0, item);
            }
        });
        this.mSearchAdapter = addressListAdapter;
        stepOSRecyclerView.setAdapter(addressListAdapter);
        stepOSRecyclerView.f14915B0 = true;
        stepOSRecyclerView.setSelector(R.drawable.selector_transient);
    }

    private final void setToolbar(int resId) {
        ActivityAddressMainBinding binding = getBinding();
        binding.toolbarTitle.setText(resId);
        final int i4 = 0;
        binding.cancel.setOnClickListener(new View.OnClickListener(this) { // from class: com.stepos.alphame.persona.address.ui.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AddressMainActivity f11190b;

            {
                this.f11190b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i5 = i4;
                AddressMainActivity addressMainActivity = this.f11190b;
                switch (i5) {
                    case 0:
                        AddressMainActivity.setToolbar$lambda$2$lambda$0(addressMainActivity, view);
                        break;
                    default:
                        AddressMainActivity.setToolbar$lambda$2$lambda$1(addressMainActivity, view);
                        break;
                }
            }
        });
        final int i5 = 1;
        binding.save.setOnClickListener(new View.OnClickListener(this) { // from class: com.stepos.alphame.persona.address.ui.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AddressMainActivity f11190b;

            {
                this.f11190b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i52 = i5;
                AddressMainActivity addressMainActivity = this.f11190b;
                switch (i52) {
                    case 0:
                        AddressMainActivity.setToolbar$lambda$2$lambda$0(addressMainActivity, view);
                        break;
                    default:
                        AddressMainActivity.setToolbar$lambda$2$lambda$1(addressMainActivity, view);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setToolbar$lambda$2$lambda$0(AddressMainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AddressRequester addressRequester = this$0.mRequester;
        AddressRequester addressRequester2 = null;
        if (addressRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester = null;
        }
        int pageId = addressRequester.get_pageId();
        AddressPage addressPage = AddressPage.MainPage;
        if (pageId == addressPage.getType()) {
            this$0.onBackPressed();
            return;
        }
        Intrinsics.checkNotNull(view);
        this$0.hideSoftInput(view);
        this$0.updateUiWhenShowMainPage();
        AddressRequester addressRequester3 = this$0.mRequester;
        if (addressRequester3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester3 = null;
        }
        addressRequester3.setPageId(addressPage.getType());
        AddressRequester addressRequester4 = this$0.mRequester;
        if (addressRequester4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            addressRequester2 = addressRequester4;
        }
        addressRequester2.requestCacheMainAddressList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setToolbar$lambda$2$lambda$1(AddressMainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AddressRequester addressRequester = this$0.mRequester;
        AddressRequester addressRequester2 = null;
        if (addressRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester = null;
        }
        AddressMainListAdapter addressMainListAdapter = this$0.mMainAdapter;
        if (addressMainListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainAdapter");
            addressMainListAdapter = null;
        }
        AddressInfo finalResult = addressRequester.getFinalResult(addressMainListAdapter.get_selectedIndex());
        PageMessenger pageMessenger = this$0.mMessenger;
        if (pageMessenger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessenger");
            pageMessenger = null;
        }
        AddressRequester addressRequester3 = this$0.mRequester;
        if (addressRequester3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester3 = null;
        }
        pageMessenger.input(new AddressMessages(addressRequester3.get_eventId(), finalResult));
        this$0.sendResultForRequester(finalResult);
        AddressRequester addressRequester4 = this$0.mRequester;
        if (addressRequester4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            addressRequester2 = addressRequester4;
        }
        addressRequester2.saveData(finalResult);
        this$0.finish();
    }

    private final void setupViews(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(21);
        setMainPage(savedInstanceState);
        setSearchPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLocationIcon(AddressEntity item) {
        String name = item.getName();
        AddressRequester addressRequester = this.mRequester;
        if (addressRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester = null;
        }
        AddressEntity currentAddress = addressRequester.getMCurrentAddress();
        AlphaMeLogger.debugLog("Personal", "updateLocationIcon item name " + name + " current item " + (currentAddress != null ? currentAddress.getName() : null));
        String name2 = item.getName();
        AddressRequester addressRequester2 = this.mRequester;
        if (addressRequester2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester2 = null;
        }
        AddressEntity currentAddress2 = addressRequester2.getMCurrentAddress();
        getBinding().btLocation.setBackground(androidx.core.content.a.b(this, Intrinsics.areEqual(name2, currentAddress2 != null ? currentAddress2.getName() : null) ? R.drawable.current_location : R.drawable.not_current_location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMarker(LatLng centerPoint, float zoom) {
        if (this.mMap == null) {
            return;
        }
        BitmapDescriptor bitmapDescriptorFromView = BitmapDescriptorFactory.fromView(LayoutInflater.from(this).inflate(R.layout.map_marker, (ViewGroup) this.mMapView, false));
        Marker marker = this.mCurrentMarker;
        BaiduMap baiduMap = null;
        if (marker == null) {
            BaiduMap baiduMap2 = this.mMap;
            if (baiduMap2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMap");
                baiduMap2 = null;
            }
            Overlay overlayAddOverlay = baiduMap2.addOverlay(new MarkerOptions().position(centerPoint).icon(bitmapDescriptorFromView));
            Intrinsics.checkNotNull(overlayAddOverlay, "null cannot be cast to non-null type com.baidu.mapapi.map.Marker");
            this.mCurrentMarker = (Marker) overlayAddOverlay;
        } else {
            if (marker != null) {
                marker.setPosition(centerPoint);
            }
            Marker marker2 = this.mCurrentMarker;
            if (marker2 != null) {
                marker2.setIcon(bitmapDescriptorFromView);
            }
        }
        BaiduMap baiduMap3 = this.mMap;
        if (baiduMap3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
        } else {
            baiduMap = baiduMap3;
        }
        baiduMap.animateMapStatus(MapStatusUpdateFactory.newLatLngZoom(centerPoint, zoom));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUiWhenShowMainPage() {
        ActivityAddressMainBinding binding = getBinding();
        binding.mcSearchEdit.getText().clear();
        binding.mcSearchEdit.clearFocus();
        ViewKt.gone((ViewGroup) binding.searchAddressLayout);
        ViewKt.visible(binding.save);
        ViewKt.gone(binding.mcInputClear);
        ViewKt.visible((ViewGroup) binding.mainAddressLayout);
    }

    private final void updateUiWhenShowSearchPage() {
        ActivityAddressMainBinding binding = getBinding();
        ViewKt.gone((ViewGroup) binding.mainAddressLayout);
        ViewKt.visible((ViewGroup) binding.searchAddressLayout);
        ViewKt.gone(binding.save);
    }

    @Override // com.stepos.architecture.ui.stepos.d
    public void initViewModel() {
        n0 activityScopeViewModel = getActivityScopeViewModel(AddressRequester.class);
        Intrinsics.checkNotNullExpressionValue(activityScopeViewModel, "getActivityScopeViewModel(...)");
        this.mRequester = (AddressRequester) activityScopeViewModel;
        n0 applicationScopeViewModel = getApplicationScopeViewModel(PageMessenger.class);
        Intrinsics.checkNotNullExpressionValue(applicationScopeViewModel, "getApplicationScopeViewModel(...)");
        this.mMessenger = (PageMessenger) applicationScopeViewModel;
    }

    @Override // com.stepos.architecture.ui.stepos.d, stepos.support.v7.app.D, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this._binding = ActivityAddressMainBinding.inflate(getLayoutInflater());
        setContentView(getBinding().getRoot());
        ((G) getLitePopup()).b();
        setupViews(savedInstanceState);
        int intExtra = getIntent().getIntExtra(PersonalContract.KEY_PAGE, EventId.HOME_ADDRESS.getId());
        setToolbar(getTitleResId(intExtra));
        AddressRequester addressRequester = this.mRequester;
        if (addressRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            addressRequester = null;
        }
        addressRequester.setEventId(intExtra);
        observe();
    }

    @Override // com.stepos.architecture.ui.stepos.d, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        GeoCoder geoCoder = this.mGeoCoder;
        if (geoCoder != null) {
            if (geoCoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGeoCoder");
                geoCoder = null;
            }
            geoCoder.destroy();
        }
        MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onDestroy();
        }
        this._binding = null;
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(@Nullable GeoCodeResult result) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(@Nullable ReverseGeoCodeResult result) {
        if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
            return;
        }
        AlphaMeLogger.debugLog("Personal", "onRegeocodeSearched " + result);
        String address = result.getAddress();
        if (address == null) {
            return;
        }
        AlphaMeLogger.debugLog("Personal", "address ".concat(address));
        ReverseGeoCodeResult.AddressComponent addressDetail = result.getAddressDetail();
        AddressRequester addressRequester = null;
        String str = addressDetail != null ? addressDetail.district : null;
        if (str == null) {
            str = "";
        }
        AddressEntity addressEntity = new AddressEntity(PersonalDataType.CUSTOM.getType(), address, str, this.mClickPointLongitude, this.mClickPointLatitude, true);
        AddressRequester addressRequester2 = this.mRequester;
        if (addressRequester2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            addressRequester = addressRequester2;
        }
        addressRequester.requestAddressTipsWhenShowMainPage(addressEntity, false, false);
    }

    @Override // com.stepos.architecture.ui.stepos.d, androidx.fragment.app.G, android.app.Activity
    public void onPause() {
        super.onPause();
        MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    @Override // stepos.support.v7.app.D, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, android.app.Activity
    public void onResume() {
        super.onResume();
        MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    @Override // stepos.support.v7.app.D, stepos.support.v7.app.AbstractActivityC0866k, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onSaveInstanceState(outState);
        }
    }
}
