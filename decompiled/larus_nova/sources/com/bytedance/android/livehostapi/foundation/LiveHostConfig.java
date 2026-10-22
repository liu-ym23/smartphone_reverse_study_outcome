package com.bytedance.android.livehostapi.foundation;

import android.content.Context;
import com.bytedance.android.live.AbsLiveAppInfo;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.bytedance.android.livehostapi.platform.IHostConfig;
import com.bytedance.android.livehostapi.platform.depend.IHostAppConfig;
import com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig;
import com.bytedance.android.livehostapi.platform.depend.IPropertyCache;
import com.bytedance.ies.utility.SharedPrefHelper;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public class LiveHostConfig implements IHostConfig {
    private final IHostAppConfig mHostAppConfig;
    private final IPropertyCache mProperty;

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.foundation.LiveHostConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class HostAppConfig implements IHostAppConfig {
        private HostAppConfig() {
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public boolean canPlayInMobile() {
            return false;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public int enableHotsoonCityLiveVideoMix() {
            return 0;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IInitServiceOpt
        public boolean enableInitServiceOpt() {
            return false;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public boolean enableLiveVideoMixOpt() {
            return false;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public String getMobileFlowUrl() {
            return "";
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public boolean isLivePlayFragmentOpen() {
            return false;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public boolean isMessageJsonPrintEnable() {
            return true;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public boolean isNetworkStateChanged() {
            return false;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public boolean isShowDebugInfo() {
            return false;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public void setCanPlayInMobile(boolean r100) {
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public void setLiveFragmentOpen(boolean r100) {
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public void setSettingLoaded(boolean r100) {
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public boolean settingLoaded() {
            return false;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public boolean isFreeFlow() {
            IAppInfo r100 = BDLiveSdk.getAppInfo();
            if ((r100 instanceof AbsLiveAppInfo) == true) goto L5;
            return false;
        L5:
            return ((AbsLiveAppInfo) r100).isFreeFlow();
        }

        public /* synthetic */ HostAppConfig(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig
        public Map<String, String> getPreviewScrollAlphaConfig(String r100) {
            return Collections.emptyMap();
        }
    }

    public static class Property implements IPropertyCache {
        private static final String LIVE_SP_KEY = "live-app-core-sdk";
        private Map<String, Object> cachePropertyMap;
        private SharedPrefHelper pref;

        public Property(Context r100) {
            this.cachePropertyMap = new HashMap();
            this.pref = SharedPrefHelper.c(r100, LIVE_SP_KEY);
            k.l(IPropertyCache.class, this);
        }

        private static void checkArgument(boolean r100) {
            if (r100 == false) goto L5;
            return;
        L5:
            throw new IllegalArgumentException();
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public boolean getBoolean(IPropertyCache.IProperty r100) {
            if (r100.type() != IPropertyCache.PropertyType.Boolean) goto L5;
            boolean r101 = true;
        L6:
            checkArgument(r101);
            Boolean r102 = (Boolean) this.cachePropertyMap.get(r100.key());
            if (r102 != null) goto L14;
            if (r100.supportPersist() == false) goto L11;
            r102 = Boolean.valueOf(this.pref.f(r100.key(), ((Boolean) r100.defValue()).booleanValue()));
        L12:
            this.cachePropertyMap.put(r100.key(), r102);
            goto L14
        L11:
            r102 = (Boolean) r100.defValue();
        L14:
            return r102.booleanValue();
        L5:
            r101 = false;
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public float getFloat(IPropertyCache.IProperty r100) {
            if (r100.type() != IPropertyCache.PropertyType.Float) goto L5;
            boolean r101 = true;
        L6:
            checkArgument(r101);
            Float r102 = (Float) this.cachePropertyMap.get(r100.key());
            if (r102 != null) goto L14;
            if (r100.supportPersist() == false) goto L11;
            r102 = Float.valueOf(this.pref.g(r100.key(), ((Float) r100.defValue()).floatValue()));
        L12:
            this.cachePropertyMap.put(r100.key(), r102);
            goto L14
        L11:
            r102 = (Float) r100.defValue();
        L14:
            return r102.floatValue();
        L5:
            r101 = false;
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public int getInt(IPropertyCache.IProperty r100) {
            if (r100.type() != IPropertyCache.PropertyType.Integer) goto L5;
            boolean r101 = true;
        L6:
            checkArgument(r101);
            Integer r102 = (Integer) this.cachePropertyMap.get(r100.key());
            if (r102 != null) goto L14;
            if (r100.supportPersist() == false) goto L11;
            r102 = Integer.valueOf(this.pref.h(r100.key(), ((Integer) r100.defValue()).intValue()));
        L12:
            this.cachePropertyMap.put(r100.key(), r102);
            goto L14
        L11:
            r102 = (Integer) r100.defValue();
        L14:
            return r102.intValue();
        L5:
            r101 = false;
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public long getLong(IPropertyCache.IProperty r100) {
            if (r100.type() != IPropertyCache.PropertyType.Long) goto L5;
            boolean r101 = true;
        L6:
            checkArgument(r101);
            Long r102 = (Long) this.cachePropertyMap.get(r100.key());
            if (r102 != null) goto L14;
            if (r100.supportPersist() == false) goto L11;
            r102 = Long.valueOf(this.pref.i(r100.key(), ((Long) r100.defValue()).longValue()));
        L12:
            this.cachePropertyMap.put(r100.key(), r102);
            goto L14
        L11:
            r102 = (Long) r100.defValue();
        L14:
            return r102.longValue();
        L5:
            r101 = false;
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public Set<String> getStrSet(IPropertyCache.IProperty r100) {
            if (r100.type() != IPropertyCache.PropertyType.StrSet) goto L5;
            boolean r101 = true;
        L6:
            checkArgument(r101);
            Set<String> r102 = (Set) this.cachePropertyMap.get(r100.key());
            if (r102 == null) goto L9;
        L13:
            return r102;
        L9:
            if (r100.supportPersist() == false) goto L11;
            r102 = this.pref.k(r100.key(), (Set) r100.defValue());
        L12:
            this.cachePropertyMap.put(r100.key(), r102);
            goto L13
        L11:
            r102 = (Set) r100.defValue();
            goto L12
        L5:
            r101 = false;
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public String getString(IPropertyCache.IProperty r100) {
            if (r100.type() != IPropertyCache.PropertyType.String) goto L5;
            boolean r101 = true;
        L6:
            checkArgument(r101);
            String r102 = (String) this.cachePropertyMap.get(r100.key());
            if (r102 == null) goto L9;
        L13:
            return r102;
        L9:
            if (r100.supportPersist() == false) goto L11;
            r102 = this.pref.j(r100.key(), (String) r100.defValue());
        L12:
            this.cachePropertyMap.put(r100.key(), r102);
            goto L13
        L11:
            r102 = (String) r100.defValue();
            goto L12
        L5:
            r101 = false;
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public void removeProperty(IPropertyCache.IProperty r100) {
            this.cachePropertyMap.remove(r100.key());
            if (r100.supportPersist() == false) goto L6;
            this.pref.f249252a.edit().remove(r100.key()).apply();
            return;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public void setBoolean(IPropertyCache.IProperty r100, boolean r101) {
            if (r100.type() != IPropertyCache.PropertyType.Boolean) goto L5;
            boolean r102 = true;
        L6:
            checkArgument(r102);
            Map<String, Object> r103 = this.cachePropertyMap;
            String r104 = r100.key();
            if (r101 == false) goto L9;
            Boolean r105 = Boolean.TRUE;
        L10:
            r103.put(r104, r105);
            if (r100.supportPersist() == false) goto L14;
            this.pref.f249252a.edit().putBoolean(r100.key(), r101).apply();
            return;
        L14:
            return;
        L9:
            r105 = Boolean.FALSE;
            goto L10
        L5:
            r102 = false;
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public void setFloat(IPropertyCache.IProperty r100, float r101) {
            if (r100.type() != IPropertyCache.PropertyType.Float) goto L5;
            boolean r102 = true;
        L6:
            checkArgument(r102);
            this.cachePropertyMap.put(r100.key(), Float.valueOf(r101));
            if (r100.supportPersist() == false) goto L10;
            this.pref.f249252a.edit().putFloat(r100.key(), r101).apply();
            return;
        L10:
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public void setInt(IPropertyCache.IProperty r100, int r101) {
            if (r100.type() != IPropertyCache.PropertyType.Integer) goto L5;
            boolean r102 = true;
        L6:
            checkArgument(r102);
            this.cachePropertyMap.put(r100.key(), Integer.valueOf(r101));
            if (r100.supportPersist() == false) goto L10;
            this.pref.f249252a.edit().putInt(r100.key(), r101).apply();
            return;
        L10:
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public void setLong(IPropertyCache.IProperty r100, long r101) {
            if (r100.type() != IPropertyCache.PropertyType.Long) goto L5;
            boolean r102 = true;
        L6:
            checkArgument(r102);
            this.cachePropertyMap.put(r100.key(), Long.valueOf(r101));
            if (r100.supportPersist() == false) goto L10;
            this.pref.f249252a.edit().putLong(r100.key(), r101).apply();
            return;
        L10:
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public void setStrSet(IPropertyCache.IProperty r100, Set<String> r101) {
            if (r100.type() != IPropertyCache.PropertyType.StrSet) goto L5;
            boolean r102 = true;
        L6:
            checkArgument(r102);
            this.cachePropertyMap.put(r100.key(), r101);
            if (r100.supportPersist() == false) goto L10;
            this.pref.f249252a.edit().putStringSet(r100.key(), r101).apply();
            return;
        L10:
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache
        public void setString(IPropertyCache.IProperty r100, String r101) {
            if (r100.type() != IPropertyCache.PropertyType.String) goto L5;
            boolean r102 = true;
        L6:
            checkArgument(r102);
            this.cachePropertyMap.put(r100.key(), r101);
            if (r100.supportPersist() == false) goto L10;
            this.pref.f249252a.edit().putString(r100.key(), r101).apply();
            return;
        L10:
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    public LiveHostConfig() {
        this.mHostAppConfig = new HostAppConfig(null);
        this.mProperty = new Property(BDLiveSdk.getContext());
        k.l(IHostConfig.class, this);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostConfig, com.bytedance.android.livehostapi.platform.IMiddlewareHostConfig
    public /* bridge */ /* synthetic */ IMiddlewareHostAppConfig appConfig() {
        return appConfig();
    }

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostConfig
    public IPropertyCache pref() {
        return this.mProperty;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostConfig, com.bytedance.android.livehostapi.platform.IMiddlewareHostConfig
    public IHostAppConfig appConfig() {
        return this.mHostAppConfig;
    }
}
