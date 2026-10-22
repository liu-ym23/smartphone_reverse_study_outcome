package com.android.server.app;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityTaskManager;
import android.app.IActivityTaskManager;
import android.content.Context;
import android.content.Intent;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.service.games.IGameService;
import android.service.games.IGameSessionService;
import com.android.internal.infra.ServiceConnector;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.ScreenshotHelper;
import com.android.server.LocalServices;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import com.android.server.wm.WindowManagerService;

/* JADX INFO: loaded from: classes.dex */
final class GameServiceProviderInstanceFactoryImpl implements GameServiceProviderInstanceFactory {
    private final Context mContext;

    private static final class GameServiceConnector extends ServiceConnector.Impl<IGameService> {
        private static final int BINDING_FLAGS = 1048576;
        private static final int DISABLE_AUTOMATIC_DISCONNECT_TIMEOUT = 0;

        GameServiceConnector(Context context, GameServiceConfiguration.GameServiceComponentConfiguration configuration) {
            super(context, new Intent("android.service.games.action.GAME_SERVICE").setComponent(configuration.getGameServiceComponentName()), 1048576, configuration.getUserHandle().getIdentifier(), new GameServiceProviderInstanceFactoryImpl$GameServiceConnector$$ExternalSyntheticLambda0());
        }

        protected long getAutoDisconnectTimeoutMs() {
            return 0;
        }
    }

    private static final class GameSessionServiceConnector extends ServiceConnector.Impl<IGameSessionService> {
        private static final int BINDING_FLAGS = 135790592;
        private static final int DISABLE_AUTOMATIC_DISCONNECT_TIMEOUT = 0;

        GameSessionServiceConnector(Context context, GameServiceConfiguration.GameServiceComponentConfiguration configuration) {
            super(context, new Intent("android.service.games.action.GAME_SESSION_SERVICE").setComponent(configuration.getGameSessionServiceComponentName()), BINDING_FLAGS, configuration.getUserHandle().getIdentifier(), new GameServiceProviderInstanceFactoryImpl$GameSessionServiceConnector$$ExternalSyntheticLambda0());
        }

        protected long getAutoDisconnectTimeoutMs() {
            return 0;
        }
    }

    GameServiceProviderInstanceFactoryImpl(Context context) {
        this.mContext = context;
    }

    @Override // com.android.server.app.GameServiceProviderInstanceFactory
    public GameServiceProviderInstance create(GameServiceConfiguration.GameServiceComponentConfiguration configuration) {
        UserHandle userHandle = configuration.getUserHandle();
        IActivityTaskManager activityTaskManager = ActivityTaskManager.getService();
        return new GameServiceProviderInstanceImpl(userHandle, BackgroundThread.getExecutor(), this.mContext, new GameTaskInfoProvider(userHandle, activityTaskManager, new GameClassifierImpl(this.mContext.getPackageManager())), ActivityManager.getService(), (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class), activityTaskManager, (WindowManagerService) ServiceManager.getService("window"), (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class), (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class), new GameServiceConnector(this.mContext, configuration), new GameSessionServiceConnector(this.mContext, configuration), new ScreenshotHelper(this.mContext));
    }
}
