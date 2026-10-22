package com.stepos.launcher.assistant.quickstep;

import com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent;

/* loaded from: classes.dex */
public abstract class RemoteTransitionDelegate {
    protected final ScrollOverlayComponent mComponent;

    public RemoteTransitionDelegate(ScrollOverlayComponent scrollOverlayComponent) {
        this.mComponent = scrollOverlayComponent;
    }

    public abstract void onRemoteTransitionEnd(RemoteTransitionParams remoteTransitionParams);

    public abstract void onRemoteTransitionStart(RemoteTransitionParams remoteTransitionParams);
}
