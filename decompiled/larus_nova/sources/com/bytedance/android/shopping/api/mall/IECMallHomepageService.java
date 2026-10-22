package com.bytedance.android.shopping.api.mall;

import com.google.gson.JsonObject;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\u0004'()*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\fH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u000fH&J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&J,\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0017H&J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0015H&J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H&J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H&J\n\u0010%\u001a\u0004\u0018\u00010\u0012H&J\n\u0010&\u001a\u0004\u0018\u00010\u0012H&¨\u0006+"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/IECMallHomepageService;", "", "Lcom/bytedance/android/shopping/api/mall/g;", "homepage", "", "setupInstance", "releaseInstance", "getHomepageInstance", "Lcom/bytedance/android/shopping/api/mall/IECMallHomepageService$a;", "listener", "registerDataSetChangeListener", "unregisterDataSetChangeListener", "Lcom/bytedance/android/shopping/api/mall/IECMallHomepageService$c;", "registerRenderListener", "unregisterRenderListener", "Lcom/bytedance/android/shopping/api/mall/IECMallHomepageService$b;", "registerRefreshListener", "unregisterRefreshListener", "", ForwardDependency$ForwardLocation.FLAG, "notifyDataSetChanged", "", "isFromCache", "", "extraInfo", "notifyRenderFinished", "isManual", "notifyRefreshStart", "isSuccess", "notifyRefreshEnd", "themeId", "recordLoginThemeId", SocialConstants.PARAM_APP_DESC, "recordLoginDesc", "Lcom/google/gson/JsonObject;", "operations", "handleMemoryOperations", "getLoginThemeId", "getLoginDesc", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "Section", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECMallHomepageService {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/IECMallHomepageService$Section;", "", "HEADER", "GUESS_YOU_LIKE", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Section extends Enum<Section> {
        public static final Section GUESS_YOU_LIKE = null;
        public static final Section HEADER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Section[] f170201a = null;

        static {
            Section r100 = new Section("HEADER", 0);
            HEADER = r100;
            Section r101 = new Section("GUESS_YOU_LIKE", 1);
            GUESS_YOU_LIKE = r101;
            f170201a = new Section[]{r100, r101};
        }

        public static Section valueOf(String r100) {
            return (Section) r27.a.a(Section.class, r100);
        }

        public static Section[] values() {
            return (Section[]) f170201a.clone();
        }

        public Section(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    g getHomepageInstance();

    String getLoginDesc();

    String getLoginThemeId();

    void handleMemoryOperations(JsonObject r100);

    void notifyDataSetChanged(g r100, String r101);

    void notifyRefreshEnd(g r100, boolean r101, boolean r102);

    void notifyRefreshStart(g r100, boolean r101);

    void notifyRenderFinished(g r100, boolean r101, Map<String, ? extends Object> r102);

    void recordLoginDesc(String r100);

    void recordLoginThemeId(String r100);

    void registerDataSetChangeListener(a r100);

    void registerRefreshListener(b r100);

    void registerRenderListener(c r100);

    void releaseInstance(g r100);

    void setupInstance(g r100);

    void unregisterDataSetChangeListener(a r100);

    void unregisterRefreshListener(b r100);

    void unregisterRenderListener(c r100);
}
