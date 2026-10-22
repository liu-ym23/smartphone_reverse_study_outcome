package Q3;

import android.content.ComponentName;

/* loaded from: classes2.dex */
public interface b {
    void a(ComponentName componentName);

    void onBindingDied(ComponentName componentName);

    void onNullBinding(ComponentName componentName);

    void onServiceDisconnected(ComponentName componentName);
}
