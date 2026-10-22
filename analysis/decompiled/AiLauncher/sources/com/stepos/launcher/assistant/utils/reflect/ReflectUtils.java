package com.stepos.launcher.assistant.utils.reflect;

import B0.d;
import android.appwidget.AppWidgetHostView;
import android.graphics.Matrix;
import android.os.IBinder;
import android.view.DragEvent;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RemoteViews;

/* loaded from: classes.dex */
public class ReflectUtils {
    public static void addPRIVATE_FLAG_INTERCEPT_GLOBAL_DRAG_AND_DROPFlag(WindowManager.LayoutParams layoutParams) {
        try {
            setPrivateFlags(layoutParams, getPrivateFlags(layoutParams) | getPRIVATE_FLAG_INTERCEPT_GLOBAL_DRAG_AND_DROP());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void addPrivateFlags(Window window, int i10) {
        try {
            ReflectHelper.invoke(window, "addPrivateFlags", (Class<?>[]) new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i10)});
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void cancelDragAndDrop(d<IBinder, Object> dVar) {
        IBinder iBinder;
        Object obj;
        if (dVar == null || (iBinder = dVar.f1411a) == null || (obj = dVar.f1412b) == null) {
            return;
        }
        try {
            ReflectHelper.invoke(obj, "cancelDragAndDrop", (Class<?>[]) new Class[]{IBinder.class, Boolean.TYPE}, new Object[]{iBinder, Boolean.FALSE});
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static Object getAttachInfo(View view) throws NoSuchFieldException {
        return ReflectHelper.getField(view, "mAttachInfo");
    }

    public static Surface getAttachInfoDragSurface(View view) {
        try {
            Object attachInfo = getAttachInfo(view);
            if (attachInfo != null) {
                return (Surface) ReflectHelper.getField(attachInfo, "mDragSurface");
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static int getDRAG_FLAG_REQUEST_SURFACE_FOR_RETURN_ANIMATION() {
        try {
            return ((Integer) ReflectHelper.getStaticField("android.view.View", "DRAG_FLAG_REQUEST_SURFACE_FOR_RETURN_ANIMATION")).intValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static SurfaceControl getDragSurface(DragEvent dragEvent) {
        try {
            return (SurfaceControl) ReflectHelper.invoke(dragEvent, "getDragSurface", (Class<?>[]) null, (Object[]) null);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static RemoteViews getLastInflatedRemoteViews(AppWidgetHostView appWidgetHostView) {
        try {
            return (RemoteViews) ReflectHelper.getField(appWidgetHostView, "mLastInflatedRemoteViews");
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static int getPRIVATE_FLAG_INTERCEPT_GLOBAL_DRAG_AND_DROP() {
        try {
            return ((Integer) ReflectHelper.getStaticField("android.view.WindowManager$LayoutParams", "PRIVATE_FLAG_INTERCEPT_GLOBAL_DRAG_AND_DROP")).intValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static int getPrivateFlags(WindowManager.LayoutParams layoutParams) {
        try {
            return ((Integer) ReflectHelper.getField(layoutParams, "privateFlags")).intValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static d<IBinder, Object> getViewAttachInfo(View view) {
        try {
            Object attachInfo = getAttachInfo(view);
            IBinder iBinder = (IBinder) ReflectHelper.getField(attachInfo, "mDragToken");
            Object field = ReflectHelper.getField(attachInfo, "mSession");
            if (iBinder == null || field == null) {
                return null;
            }
            return d.a(iBinder, field);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static void removeSurfaceControl(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl) {
        try {
            ReflectHelper.invoke(transaction, "remove", (Class<?>[]) new Class[]{SurfaceControl.class}, new Object[]{surfaceControl});
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void setPrivateFlags(WindowManager.LayoutParams layoutParams, int i10) {
        try {
            ReflectHelper.setField(layoutParams, WindowManager.LayoutParams.class, "privateFlags", Integer.valueOf(i10));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void setSurfaceControlMatrix(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, Matrix matrix, float[] fArr) {
        try {
            ReflectHelper.invoke(transaction, "setMatrix", (Class<?>[]) new Class[]{SurfaceControl.class, Matrix.class, float[].class}, new Object[]{surfaceControl, matrix, fArr});
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
