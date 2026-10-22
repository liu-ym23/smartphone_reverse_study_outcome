package com.stepos.launcher.assistant.widgetdrag;

import B0.d;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import com.stepos.launcher.assistant.utils.Utils;
import com.stepos.launcher.assistant.utils.XLog;
import com.stepos.launcher.assistant.utils.reflect.ReflectUtils;

/* loaded from: classes.dex */
public class GlobalDragController implements IGlobalDragListener {
    private static final String TAG = "GlobalWidgetDrag";
    private boolean mCancelDragAndDrop;
    private DragEvent mDragEndEvent;
    private GlobalDragItemInfo mDragItemInfo;
    private OnDragListener mDragListener;
    private d<IBinder, Object> mDragViewAttachInfo;
    private boolean mHandleDropEvent;

    public GlobalDragController(Context context) {
    }

    private boolean handleDragStartEvent(DragEvent dragEvent) {
        ClipDescription clipDescription = dragEvent.getClipDescription();
        if (clipDescription == null || !clipDescription.hasMimeType(GlobalDragConstant.MIME_TYPE)) {
            XLog.i(TAG, "[DragController#handleDragStartEvent] but not Launcher Drag !");
            return false;
        }
        String string = clipDescription.getExtras().getString(GlobalDragConstant.DRAG_CONFIG_KEY, null);
        int i10 = clipDescription.getExtras().getInt(GlobalDragConstant.DRAG_TYPE_KEY, -1);
        XLog.i(TAG, "[handleDragStartEvent] jsonData:" + string + ", dragType:" + i10);
        if (!TextUtils.isEmpty(string) && i10 != -1) {
            GlobalDragItemInfo globalDragItemInfo = getGlobalDragItemInfoParser().parse(string, i10);
            XLog.i(TAG, "[handleDragStartEvent] jsonData:" + string);
            if (isDragItemInfoValid(globalDragItemInfo)) {
                this.mDragItemInfo = globalDragItemInfo;
                return true;
            }
            XLog.i(TAG, "[handleDragStartEvent] DragItemInfo is not Valid.");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onDrag(View view, DragEvent dragEvent) {
        OnDragListener onDragListener;
        OnDragListener onDragListener2;
        switch (dragEvent.getAction()) {
            case 1:
                this.mHandleDropEvent = false;
                this.mCancelDragAndDrop = false;
                this.mDragEndEvent = null;
                this.mDragItemInfo = null;
                boolean zHandleDragStartEvent = handleDragStartEvent(dragEvent);
                XLog.i(TAG, "DragController receive ACTION_DRAG_STARTED result : " + zHandleDragStartEvent);
                if (zHandleDragStartEvent && (onDragListener = this.mDragListener) != null) {
                    onDragListener.onDragStart(view, dragEvent, this.mDragItemInfo);
                }
                return zHandleDragStartEvent;
            case 2:
                OnDragListener onDragListener3 = this.mDragListener;
                if (onDragListener3 != null) {
                    onDragListener3.onDragLocation(view, dragEvent, this.mDragItemInfo);
                }
                return true;
            case 3:
                this.mHandleDropEvent = true;
                if (this.mDragItemInfo != null && (onDragListener2 = this.mDragListener) != null) {
                    onDragListener2.onDragDrop(view, dragEvent, ReflectUtils.getDragSurface(dragEvent), this.mDragItemInfo);
                }
                XLog.i(TAG, "DragController receive ACTION_DROP.");
                return true;
            case 4:
                this.mDragEndEvent = dragEvent;
                XLog.i(TAG, "DragController receive ACTION_DRAG_ENDED. event:" + dragEvent);
                OnDragListener onDragListener4 = this.mDragListener;
                if (onDragListener4 != null) {
                    onDragListener4.onDragEnded(view, dragEvent, this.mDragItemInfo);
                }
                this.mDragViewAttachInfo = null;
                return true;
            case 5:
                XLog.i(TAG, "DragController receive ACTION_DRAG_ENTERED.");
                OnDragListener onDragListener5 = this.mDragListener;
                if (onDragListener5 != null) {
                    onDragListener5.onDragEntered(view, dragEvent, this.mDragItemInfo);
                }
                return true;
            case 6:
                XLog.i(TAG, "DragController receive ACTION_DRAG_EXITED.");
                OnDragListener onDragListener6 = this.mDragListener;
                if (onDragListener6 != null) {
                    onDragListener6.onDragExited(view, dragEvent, this.mDragItemInfo);
                }
                return true;
            default:
                return false;
        }
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IGlobalDragListener
    public synchronized boolean cancelDragAndDrop() {
        GlobalDragItemInfo globalDragItemInfo = this.mDragItemInfo;
        if (globalDragItemInfo != null && this.mDragViewAttachInfo != null) {
            if (globalDragItemInfo.getDragSource() != 2 && this.mDragItemInfo.getDragSource() != 6) {
                return false;
            }
            if (this.mHandleDropEvent || this.mCancelDragAndDrop) {
                return false;
            }
            this.mCancelDragAndDrop = true;
            ReflectUtils.cancelDragAndDrop(this.mDragViewAttachInfo);
            return true;
        }
        return false;
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IGlobalDragListener
    public DragEvent getDragEvent(int i10) {
        if (i10 == 4) {
            return this.mDragEndEvent;
        }
        return null;
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IGlobalDragListener
    public GlobalDragItemInfo getDragItemInfo() {
        return this.mDragItemInfo;
    }

    public GlobalDragItemInfoParser getGlobalDragItemInfoParser() {
        return GlobalDragItemInfoParser.DEFAULT_PARSER;
    }

    public boolean hideDragSurface(GlobalDragItemInfo globalDragItemInfo) {
        return true;
    }

    public boolean isDragItemInfoValid(GlobalDragItemInfo globalDragItemInfo) {
        if (globalDragItemInfo instanceof GlobalDragWidgetInfo) {
            GlobalDragWidgetInfo globalDragWidgetInfo = (GlobalDragWidgetInfo) globalDragItemInfo;
            return (globalDragWidgetInfo.getPackageName() == null || globalDragWidgetInfo.getClassName() == null) ? false : true;
        }
        if (globalDragItemInfo instanceof GlobalDragWidgetStackInfo) {
            return !((GlobalDragWidgetStackInfo) globalDragItemInfo).getWidgetInfoList().isEmpty();
        }
        return false;
    }

    public View.DragShadowBuilder onCreateDragShadowBuilder(View view, final GlobalDragItemInfo globalDragItemInfo) {
        return new View.DragShadowBuilder(view) { // from class: com.stepos.launcher.assistant.widgetdrag.GlobalDragController.1
            @Override // android.view.View.DragShadowBuilder
            public void onDrawShadow(Canvas canvas) {
                float originScale = globalDragItemInfo.getOriginScale();
                if (originScale == 1.0f) {
                    super.onDrawShadow(canvas);
                    return;
                }
                canvas.save();
                canvas.scale(originScale, originScale);
                super.onDrawShadow(canvas);
                canvas.restore();
            }

            @Override // android.view.View.DragShadowBuilder
            public void onProvideShadowMetrics(Point point, Point point2) {
                super.onProvideShadowMetrics(point, point2);
                float dragScale = (globalDragItemInfo.getDragScale() - 1.0f) / 2.0f;
                point2.set((int) (globalDragItemInfo.getTouchPointX() + (globalDragItemInfo.getViewWidth() * dragScale)), (int) (globalDragItemInfo.getTouchPointY() + (dragScale * globalDragItemInfo.getViewHeight())));
            }
        };
    }

    public boolean onStartDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i10) {
        return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i10);
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IGlobalDragListener
    public void register(View view) {
        if (view != null) {
            view.setOnDragListener(new View.OnDragListener() { // from class: com.stepos.launcher.assistant.widgetdrag.a
                @Override // android.view.View.OnDragListener
                public final boolean onDrag(View view2, DragEvent dragEvent) {
                    return this.f30174a.onDrag(view2, dragEvent);
                }
            });
        }
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IGlobalDragListener
    public void setDragListener(OnDragListener onDragListener) {
        this.mDragListener = onDragListener;
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IGlobalDragListener
    public boolean startDrag(View view, GlobalDragItemInfo globalDragItemInfo) {
        return startDrag(view, globalDragItemInfo, null, GlobalDragConstant.DRAG_FLAG);
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IGlobalDragListener
    public void unregister(View view) {
        if (view != null) {
            view.setOnDragListener(null);
        }
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IGlobalDragListener
    public boolean startDrag(View view, GlobalDragItemInfo globalDragItemInfo, Bundle bundle, int i10) {
        if (view == null) {
            XLog.i(TAG, "startDrag need dragView not null !");
            return false;
        }
        if (globalDragItemInfo.getTouchPointX() < 0.0f || globalDragItemInfo.getTouchPointY() < 0.0f) {
            XLog.i(TAG, "Starting drag and drop but touch dimensions must not be negative, TouchPointX:" + globalDragItemInfo.getTouchPointX() + ", TouchPointY:" + globalDragItemInfo.getTouchPointY());
            return false;
        }
        if (!Utils.ATLEAST_BAKLAVA && hideDragSurface(globalDragItemInfo)) {
            i10 |= Integer.MIN_VALUE;
        }
        int i11 = i10;
        String json = getGlobalDragItemInfoParser().toJson(globalDragItemInfo);
        boolean zOnStartDragAndDrop = onStartDragAndDrop(view, GlobalDragItemInfoExt.createDragClipData(json, globalDragItemInfo.getDragType(), hideDragSurface(globalDragItemInfo)), onCreateDragShadowBuilder(view, globalDragItemInfo), bundle, i11);
        if (zOnStartDragAndDrop) {
            this.mDragViewAttachInfo = ReflectUtils.getViewAttachInfo(view);
        }
        XLog.i(TAG, "startDrag result : " + zOnStartDragAndDrop + ", dragJson:" + json);
        return zOnStartDragAndDrop;
    }
}
