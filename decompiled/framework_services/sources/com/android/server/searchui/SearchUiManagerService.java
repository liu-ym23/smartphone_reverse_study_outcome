package com.android.server.searchui;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.search.ISearchCallback;
import android.app.search.ISearchUiManager;
import android.app.search.Query;
import android.app.search.SearchContext;
import android.app.search.SearchSessionId;
import android.app.search.SearchTargetEvent;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.FrameworkResourcesServiceNameResolver;
import com.android.server.infra.ServiceNameResolver;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.FileDescriptor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class SearchUiManagerService extends AbstractMasterSystemService<SearchUiManagerService, SearchUiPerUserService> {
    private static final boolean DEBUG = false;
    private static final int MAX_TEMP_SERVICE_DURATION_MS = 120000;
    private static final String TAG = null;
    private ActivityTaskManagerInternal mActivityTaskManagerInternal;

    private class SearchUiManagerStub extends ISearchUiManager.Stub {
        final /* synthetic */ SearchUiManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$9mIv9zhp0AoEd8cx-HV4xIJzFZc, reason: not valid java name */
        public static /* synthetic */ void m8016$r8$lambda$9mIv9zhp0AoEd8cxHV4xIJzFZc(SearchSessionId r0, Query r1, ISearchCallback r2, SearchUiPerUserService r3) {
            lambda$query$2(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$EufbeJGBB3SeMvoS475AOlQhp3I(SearchSessionId r0, SearchUiPerUserService r1) {
            lambda$destroySearchSession$5(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$UsHsYkklwK1N3-GUdYipcOFfEsI, reason: not valid java name */
        public static /* synthetic */ void m8017$r8$lambda$UsHsYkklwK1N3GUdYipcOFfEsI(SearchSessionId r0, ISearchCallback r1, SearchUiPerUserService r2) {
            lambda$registerEmptyQueryResultUpdateCallback$3(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$e-qcpx1svnr6RiwEqQaYfIyfra0, reason: not valid java name */
        public static /* synthetic */ void m8018$r8$lambda$eqcpx1svnr6RiwEqQaYfIyfra0(SearchSessionId r0, ISearchCallback r1, SearchUiPerUserService r2) {
            lambda$unregisterEmptyQueryResultUpdateCallback$4(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$e4PIZHF9BRZf3fJVN24oRGj_QDg(SearchContext r0, SearchSessionId r1, IBinder r2, SearchUiPerUserService r3) {
            lambda$createSearchSession$0(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$l7DU4yCnPpNR3p1a6GqI84UBNRk(SearchSessionId r0, Query r1, SearchTargetEvent r2, SearchUiPerUserService r3) {
            lambda$notifyEvent$1(r0, r1, r2, r3);
        }

        /* synthetic */ SearchUiManagerStub(SearchUiManagerService r1, SearchUiManagerServiceIA r2) {
            this(r1);
        }

        private SearchUiManagerStub(SearchUiManagerService r1) {
            this.this$0 = r1;
        }

        public void createSearchSession(final SearchContext context, final SearchSessionId sessionId, final IBinder token) {
            runForUserLocked("createSearchSession", sessionId, new SearchUiManagerService$SearchUiManagerStub$$ExternalSyntheticLambda2(context, sessionId, token));
        }

        private static /* synthetic */ void lambda$createSearchSession$0(SearchContext context, SearchSessionId sessionId, IBinder token, SearchUiPerUserService service) {
            service.onCreateSearchSessionLocked(context, sessionId, token);
        }

        public void notifyEvent(final SearchSessionId sessionId, final Query query, final SearchTargetEvent event) {
            runForUserLocked("notifyEvent", sessionId, new SearchUiManagerService$SearchUiManagerStub$$ExternalSyntheticLambda0(sessionId, query, event));
        }

        private static /* synthetic */ void lambda$notifyEvent$1(SearchSessionId sessionId, Query query, SearchTargetEvent event, SearchUiPerUserService service) {
            service.notifyLocked(sessionId, query, event);
        }

        public void query(final SearchSessionId sessionId, final Query query, final ISearchCallback callback) {
            runForUserLocked("query", sessionId, new SearchUiManagerService$SearchUiManagerStub$$ExternalSyntheticLambda1(sessionId, query, callback));
        }

        private static /* synthetic */ void lambda$query$2(SearchSessionId sessionId, Query query, ISearchCallback callback, SearchUiPerUserService service) {
            service.queryLocked(sessionId, query, callback);
        }

        public void registerEmptyQueryResultUpdateCallback(final SearchSessionId sessionId, final ISearchCallback callback) {
            runForUserLocked("registerEmptyQueryResultUpdateCallback", sessionId, new SearchUiManagerService$SearchUiManagerStub$$ExternalSyntheticLambda3(sessionId, callback));
        }

        private static /* synthetic */ void lambda$registerEmptyQueryResultUpdateCallback$3(SearchSessionId sessionId, ISearchCallback callback, SearchUiPerUserService service) {
            service.registerEmptyQueryResultUpdateCallbackLocked(sessionId, callback);
        }

        public void unregisterEmptyQueryResultUpdateCallback(final SearchSessionId sessionId, final ISearchCallback callback) {
            runForUserLocked("unregisterEmptyQueryResultUpdateCallback", sessionId, new SearchUiManagerService$SearchUiManagerStub$$ExternalSyntheticLambda4(sessionId, callback));
        }

        private static /* synthetic */ void lambda$unregisterEmptyQueryResultUpdateCallback$4(SearchSessionId sessionId, ISearchCallback callback, SearchUiPerUserService service) {
            service.unregisterEmptyQueryResultUpdateCallbackLocked(sessionId, callback);
        }

        public void destroySearchSession(final SearchSessionId sessionId) {
            runForUserLocked("destroySearchSession", sessionId, new SearchUiManagerService$SearchUiManagerStub$$ExternalSyntheticLambda5(sessionId));
        }

        private static /* synthetic */ void lambda$destroySearchSession$5(SearchSessionId sessionId, SearchUiPerUserService service) {
            service.onDestroyLocked(sessionId);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new SearchUiManagerServiceShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }

        private void runForUserLocked(String func, SearchSessionId sessionId, Consumer<SearchUiPerUserService> c) {
            ActivityManagerInternal am = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
            int userId = am.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), sessionId.getUserId(), false, 0, null, null);
            if (SearchUiManagerService.access$000(this.this$0).isTemporary(userId) == false) goto L5;
        L9:
            long origId = Binder.clearCallingIdentity();
            Object r5 = SearchUiManagerService.access$100(this.this$0);     // Catch: Throwable -> L19
            monitor-enter(r5);     // Catch: Throwable -> L19
            SearchUiPerUserService service = (SearchUiPerUserService) SearchUiManagerService.access$200(this.this$0, userId);     // Catch: Throwable -> L16
            c.accept(service);     // Catch: Throwable -> L16
            monitor-exit(r5);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(origId);
            return;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(origId);
            throw th;
        L5:
            if (SearchUiManagerService.m8014$$Nest$fgetmActivityTaskManagerInternal(this.this$0).isCallerRecents(Binder.getCallingUid()) == true) goto L9;
            String msg = "Permission Denial: " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid();
            Slog.w(SearchUiManagerService.m8015$$Nest$sfgetTAG(), msg);
            throw new SecurityException(msg);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityTaskManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerInternal m8014$$Nest$fgetmActivityTaskManagerInternal(SearchUiManagerService r0) {
        return r0.mActivityTaskManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8015$$Nest$sfgetTAG() {
        return TAG;
    }

    static /* synthetic */ ServiceNameResolver access$000(SearchUiManagerService x0) {
        return x0.mServiceNameResolver;
    }

    static /* synthetic */ Object access$100(SearchUiManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$200(SearchUiManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    static {
        TAG = SearchUiManagerService.class.getSimpleName();
    }

    public SearchUiManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.string.config_hdmiCecSetMenuLanguageActivity), null, 17);
        this.mActivityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected SearchUiPerUserService newServiceLocked(int resolvedUserId, boolean disabled) {
        return new SearchUiPerUserService(this, this.mLock, resolvedUserId);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("search_ui", new SearchUiManagerStub(this, null));
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void enforceCallingPermissionForManagement() {
        getContext().enforceCallingPermission("android.permission.MANAGE_SEARCH_UI", TAG);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageUpdatedLocked(int userId) {
        SearchUiPerUserService service = peekServiceForUserLocked(userId);
        if (service == null) goto L6;
        service.onPackageUpdatedLocked();
        return;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageRestartedLocked(int userId) {
        SearchUiPerUserService service = peekServiceForUserLocked(userId);
        if (service == null) goto L6;
        service.onPackageRestartedLocked();
        return;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected int getMaximumTemporaryServiceDurationMs() {
        return MAX_TEMP_SERVICE_DURATION_MS;
    }
}
