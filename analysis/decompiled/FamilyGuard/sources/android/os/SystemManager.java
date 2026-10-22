package android.os;

import P2.b;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class SystemManager {
    public static void addPowerSaveWhitelistApp(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object iDeviceIdleController = getIDeviceIdleController();
        if (iDeviceIdleController == null || str == null) {
            return;
        }
        try {
            try {
                iDeviceIdleController.getClass().getMethod("addPowerSaveWhitelistApp", String.class).invoke(iDeviceIdleController, str);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } catch (Exception unused) {
            Class.forName("android.os.IDeviceIdleController").getMethod("addPowerSaveWhitelistApp", String.class).invoke(iDeviceIdleController, str);
        }
    }

    private static Object getIDeviceIdleController() {
        try {
            Class<?> clsB = b.a().b("android.os.IDeviceIdleController$Stub");
            return b.a().e(clsB, "asInterface", IBinder.class).invoke(clsB, getService("deviceidle"));
        } catch (Exception unused) {
            return null;
        }
    }

    public static IBinder getService(String str) {
        try {
            return (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, str);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
