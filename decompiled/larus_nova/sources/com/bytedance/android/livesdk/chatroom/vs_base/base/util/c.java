package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.content.ComponentName;
import android.media.AudioManager;
import androidx.media.session.MediaButtonReceiver;
import com.bytedance.android.live.core.utils.s1;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AudioManager f117924a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ComponentName f117925b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<AudioManager.OnAudioFocusChangeListener> f117926c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f117927d = null;

    public static final class a implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f117928a = null;

        static {
            f117928a = new a();
        }

        public a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int r100) {
            AudioManager r101 = c.f117924a;
            Iterator r102 = new HashSet(c.f117926c).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((AudioManager.OnAudioFocusChangeListener) r102.next()).onAudioFocusChange(r100);
            goto L4
        }
    }

    static {
        Object r100 = s1.getContext().getSystemService("audio");
        if (r100 == null) goto L7;
        f117924a = (AudioManager) r100;
        f117925b = new ComponentName(s1.getContext().getPackageName(), MediaButtonReceiver.class.getName());
        f117926c = new HashSet();
        f117927d = a.f117928a;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }
}
