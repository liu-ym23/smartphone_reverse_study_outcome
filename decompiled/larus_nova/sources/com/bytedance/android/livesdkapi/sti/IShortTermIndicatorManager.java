package com.bytedance.android.livesdkapi.sti;

import com.bytedance.android.live.core.arch.mvvm.a;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u001e\u0010\u000e\u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0010H&J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001dH&J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\n\u0010#\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010$H\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH&R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/IShortTermIndicatorManager;", "", "", "refresh", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;", "icon", "add", "activate", "", "type", "addHighPriorityShortTerm", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$ForbiddenType;", "forbiddenTypes", "setForbiddenTypesMap", "manager", "Lcom/bytedance/android/live/core/arch/mvvm/a;", "", "view", "Lio/reactivex/disposables/Disposable;", "subscribeLifetime", "remove", "", "contains", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig;", "config", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent;", "event", "notify", "Lio/reactivex/Observable;", "getNotification", "indexOf", "Lcom/bytedance/android/livesdkapi/sti/ITempShortTermManager;", "iTempShortTermManager", "setTempShortTermManager", "getTempShortTermManager", "", "getCurrentIconState", "typeId", "getPriority", "getIcons", "()Ljava/util/List;", "icons", "getOnIconChanged", "()Lio/reactivex/Observable;", "onIconChanged", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IShortTermIndicatorManager {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static List<ShortTermIcon> getCurrentIconState(IShortTermIndicatorManager r100) {
            return null;
        }

        public static ITempShortTermManager getTempShortTermManager(IShortTermIndicatorManager r100) {
            return null;
        }

        public static void refresh(IShortTermIndicatorManager r100) {
        }

        public static void setTempShortTermManager(IShortTermIndicatorManager r100, ITempShortTermManager r101) {
        }
    }

    void activate(ShortTermIcon r100);

    void add(ShortTermIcon r100);

    void addHighPriorityShortTerm(int r100);

    void config(ShortTermIndicatorConfig r100);

    boolean contains(ShortTermIcon r100);

    List<ShortTermIcon> getCurrentIconState();

    List<ShortTermIcon> getIcons();

    Observable<ShortTermIndicatorEvent> getNotification();

    Observable<List<ShortTermIcon>> getOnIconChanged();

    int getPriority(int r100);

    ITempShortTermManager getTempShortTermManager();

    int indexOf(ShortTermIcon r100);

    void notify(ShortTermIndicatorEvent r100);

    void refresh();

    void remove(ShortTermIcon r100);

    void setForbiddenTypesMap(Map<Integer, ShortTermIndicatorConfig.ForbiddenType> r100);

    void setTempShortTermManager(ITempShortTermManager r100);

    Disposable subscribeLifetime(IShortTermIndicatorManager r100, a<List<ShortTermIcon>> r101);
}
