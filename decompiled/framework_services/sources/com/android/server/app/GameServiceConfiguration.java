package com.android.server.app;

import android.content.ComponentName;
import android.os.UserHandle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class GameServiceConfiguration {
    private final GameServiceComponentConfiguration mGameServiceComponentConfiguration;
    private final String mPackageName;

    static final class GameServiceComponentConfiguration {
        private final ComponentName mGameServiceComponentName;
        private final ComponentName mGameSessionServiceComponentName;
        private final UserHandle mUserHandle;

        GameServiceComponentConfiguration(UserHandle userHandle, ComponentName gameServiceComponentName, ComponentName gameSessionServiceComponentName) {
            userHandle.getClass();
            gameServiceComponentName.getClass();
            gameSessionServiceComponentName.getClass();
            this.mUserHandle = userHandle;
            this.mGameServiceComponentName = gameServiceComponentName;
            this.mGameSessionServiceComponentName = gameSessionServiceComponentName;
        }

        public UserHandle getUserHandle() {
            return this.mUserHandle;
        }

        public ComponentName getGameServiceComponentName() {
            return this.mGameServiceComponentName;
        }

        public ComponentName getGameSessionServiceComponentName() {
            return this.mGameSessionServiceComponentName;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof GameServiceComponentConfiguration) == true) goto L8;
            return false;
        L8:
            GameServiceComponentConfiguration that = (GameServiceComponentConfiguration) o;
            if (this.mUserHandle.equals(that.mUserHandle) == false) goto L16;
            if (this.mGameServiceComponentName.equals(that.mGameServiceComponentName) == false) goto L16;
            if (this.mGameSessionServiceComponentName.equals(that.mGameSessionServiceComponentName) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mUserHandle, this.mGameServiceComponentName, this.mGameSessionServiceComponentName});
        }

        public String toString() {
            return "GameServiceComponentConfiguration{userHandle=" + this.mUserHandle + ", gameServiceComponentName=" + this.mGameServiceComponentName + ", gameSessionServiceComponentName=" + this.mGameSessionServiceComponentName + "}";
        }
    }

    GameServiceConfiguration(String packageName, GameServiceComponentConfiguration gameServiceComponentConfiguration) {
        packageName.getClass();
        this.mPackageName = packageName;
        this.mGameServiceComponentConfiguration = gameServiceComponentConfiguration;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public GameServiceComponentConfiguration getGameServiceComponentConfiguration() {
        return this.mGameServiceComponentConfiguration;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof GameServiceConfiguration) == true) goto L8;
        return false;
    L8:
        GameServiceConfiguration that = (GameServiceConfiguration) o;
        if (TextUtils.equals(this.mPackageName, that.mPackageName) == false) goto L14;
        if (Objects.equals(this.mGameServiceComponentConfiguration, that.mGameServiceComponentConfiguration) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mPackageName, this.mGameServiceComponentConfiguration});
    }

    public String toString() {
        return "GameServiceConfiguration{packageName=" + this.mPackageName + ", gameServiceComponentConfiguration=" + this.mGameServiceComponentConfiguration + '}';
    }
}
