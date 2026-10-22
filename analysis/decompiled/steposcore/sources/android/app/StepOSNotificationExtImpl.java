package android.app;

import android.graphics.drawable.Icon;
import com.stepos.framework.utils.StepOSFrameworkStubRegistry;

/* loaded from: classes.dex */
public class StepOSNotificationExtImpl implements IStepOSNotificationExt {
    public Icon getOverrideHeaderIcon(Icon notificationIcon) {
        return notificationIcon;
    }

    public static class Producer implements StepOSFrameworkStubRegistry.ImplProducer<StepOSNotificationExtImpl> {
        private static volatile StepOSNotificationExtImpl sInstance;

        /* renamed from: produceNewInstance, reason: merged with bridge method [inline-methods] */
        public StepOSNotificationExtImpl m1produceNewInstance() {
            throw new UnsupportedOperationException("StepOSNotificationExtImpl is singleton only");
        }

        /* renamed from: produceSingleton, reason: merged with bridge method [inline-methods] */
        public StepOSNotificationExtImpl m2produceSingleton() {
            if (sInstance != null) {
                return sInstance;
            }
            synchronized (Producer.class) {
                if (sInstance != null) {
                    return sInstance;
                }
                sInstance = new StepOSNotificationExtImpl();
                return sInstance;
            }
        }
    }
}
