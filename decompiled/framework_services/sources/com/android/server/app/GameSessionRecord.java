package com.android.server.app;

import android.content.ComponentName;
import android.service.games.IGameSession;
import android.view.SurfaceControlViewHost;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class GameSessionRecord {
    private final IGameSession mIGameSession;
    private final ComponentName mRootComponentName;
    private final State mState;
    private final SurfaceControlViewHost.SurfacePackage mSurfacePackage;
    private final int mTaskId;

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State GAME_SESSION_ATTACHED = null;
        public static final State GAME_SESSION_ENDED_PROCESS_DEATH = null;
        public static final State GAME_SESSION_REQUESTED = null;
        public static final State NO_GAME_SESSION_REQUESTED = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{NO_GAME_SESSION_REQUESTED, GAME_SESSION_REQUESTED, GAME_SESSION_ATTACHED, GAME_SESSION_ENDED_PROCESS_DEATH};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String name) {
            return (State) Enum.valueOf(State.class, name);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            NO_GAME_SESSION_REQUESTED = new State("NO_GAME_SESSION_REQUESTED", 0);
            GAME_SESSION_REQUESTED = new State("GAME_SESSION_REQUESTED", 1);
            GAME_SESSION_ATTACHED = new State("GAME_SESSION_ATTACHED", 2);
            GAME_SESSION_ENDED_PROCESS_DEATH = new State("GAME_SESSION_ENDED_PROCESS_DEATH", 3);
            $VALUES = $values();
        }
    }

    static GameSessionRecord awaitingGameSessionRequest(int taskId, ComponentName rootComponentName) {
        return new GameSessionRecord(taskId, State.NO_GAME_SESSION_REQUESTED, rootComponentName, null, null);
    }

    private GameSessionRecord(int taskId, State state, ComponentName rootComponentName, IGameSession gameSession, SurfaceControlViewHost.SurfacePackage surfacePackage) {
        this.mTaskId = taskId;
        this.mState = state;
        this.mRootComponentName = rootComponentName;
        this.mIGameSession = gameSession;
        this.mSurfacePackage = surfacePackage;
    }

    public boolean isAwaitingGameSessionRequest() {
        if (this.mState != State.NO_GAME_SESSION_REQUESTED) goto L5;
        return true;
    L5:
        return false;
    }

    public GameSessionRecord withGameSessionRequested() {
        return new GameSessionRecord(this.mTaskId, State.GAME_SESSION_REQUESTED, this.mRootComponentName, null, null);
    }

    public boolean isGameSessionRequested() {
        if (this.mState != State.GAME_SESSION_REQUESTED) goto L5;
        return true;
    L5:
        return false;
    }

    public GameSessionRecord withGameSession(IGameSession gameSession, SurfaceControlViewHost.SurfacePackage surfacePackage) {
        gameSession.getClass();
        return new GameSessionRecord(this.mTaskId, State.GAME_SESSION_ATTACHED, this.mRootComponentName, gameSession, surfacePackage);
    }

    public GameSessionRecord withGameSessionEndedOnProcessDeath() {
        return new GameSessionRecord(this.mTaskId, State.GAME_SESSION_ENDED_PROCESS_DEATH, this.mRootComponentName, null, null);
    }

    public boolean isGameSessionEndedForProcessDeath() {
        if (this.mState != State.GAME_SESSION_ENDED_PROCESS_DEATH) goto L5;
        return true;
    L5:
        return false;
    }

    public int getTaskId() {
        return this.mTaskId;
    }

    public ComponentName getComponentName() {
        return this.mRootComponentName;
    }

    public IGameSession getGameSession() {
        return this.mIGameSession;
    }

    public SurfaceControlViewHost.SurfacePackage getSurfacePackage() {
        return this.mSurfacePackage;
    }

    public String toString() {
        return "GameSessionRecord{mTaskId=" + this.mTaskId + ", mState=" + this.mState + ", mRootComponentName=" + this.mRootComponentName + ", mIGameSession=" + this.mIGameSession + ", mSurfacePackage=" + this.mSurfacePackage + '}';
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof GameSessionRecord) == true) goto L8;
        return false;
    L8:
        GameSessionRecord that = (GameSessionRecord) o;
        if (this.mTaskId != that.mTaskId) goto L20;
        if (this.mState != that.mState) goto L20;
        if (this.mRootComponentName.equals(that.mRootComponentName) == false) goto L20;
        if (Objects.equals(this.mIGameSession, that.mIGameSession) == false) goto L20;
        if (Objects.equals(this.mSurfacePackage, that.mSurfacePackage) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mTaskId), this.mState, this.mRootComponentName, this.mIGameSession, this.mState, this.mSurfacePackage});
    }
}
