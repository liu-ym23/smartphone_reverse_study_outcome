package com.android.server.dispatcher;

import android.os.Bundle;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ActionDispatcher extends AbsDispatcher<ActionObserver> {
    private static final AbsDispatcher.Lazy<ActionDispatcher> INSTANCE = null;
    public static final String TAG = "GameAssist.ActionDispatcher";
    protected final Map<Class<?>, ActionObserver> mActionMap;

    /* JADX INFO: renamed from: $r8$lambda$jBK7beg3KnzuEST6L4yyNiRIZ-s, reason: not valid java name */
    public static /* synthetic */ ActionDispatcher m3551$r8$lambda$jBK7beg3KnzuEST6L4yyNiRIZs() {
        return new ActionDispatcher();
    }

    @Override // com.android.server.dispatcher.AbsDispatcher
    public /* bridge */ /* synthetic */ void registerObserver(AbsDispatcher.IObserver r1) {
        registerObserver((ActionObserver) r1);
    }

    @Override // com.android.server.dispatcher.AbsDispatcher
    public /* bridge */ /* synthetic */ void unregisterObserver(AbsDispatcher.IObserver r1) {
        unregisterObserver((ActionObserver) r1);
    }

    static {
        INSTANCE = new AbsDispatcher.Lazy(new ActionDispatcher$$ExternalSyntheticLambda0());
    }

    private ActionDispatcher() {
        this.mActionMap = new ConcurrentHashMap();
    }

    public static ActionDispatcher getInstance() {
        return (ActionDispatcher) INSTANCE.get();
    }

    public void registerObserver(ActionObserver observer) {
        registerObserver(observer.getClass(), observer);
    }

    public void registerObserver(Class<?> key, ActionObserver observer) {
        this.mActionMap.put(key, observer);
    }

    public void unregisterObserver(ActionObserver observer) {
        unregisterObserver(observer.getClass());
    }

    public void unregisterObserver(Class<?> key) {
        if (key == null) goto L5;
        this.mActionMap.remove(key);
        return;
    }

    public void notifyAction(Class<?> target, String actionName) {
        notifyAction(target, actionName, new Bundle());
    }

    public void notifyAction(Class<?> target, String actionName, Bundle data) {
        ActionObserver observer = this.mActionMap.get(target);
        if (observer == null) goto L6;
        observer.onAction(actionName, data);
        return;
    }
}
