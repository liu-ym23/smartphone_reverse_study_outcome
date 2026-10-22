package com.android.ex.editstyledtext;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.Html;
import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.ArrowKeyMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.common.SimContactsConstants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class EditStyledText extends EditText {
    private static final boolean DBG = true;
    public static final int DEFAULT_FOREGROUND_COLOR = -16777216;
    public static final int DEFAULT_TRANSPARENT_COLOR = 16777215;
    public static final int HINT_MSG_BIG_SIZE_ERROR = 5;
    public static final int HINT_MSG_COPY_BUF_BLANK = 1;
    public static final int HINT_MSG_END_COMPOSE = 7;
    public static final int HINT_MSG_END_PREVIEW = 6;
    public static final int HINT_MSG_NULL = 0;
    public static final int HINT_MSG_PUSH_COMPETE = 4;
    public static final int HINT_MSG_SELECT_END = 3;
    public static final int HINT_MSG_SELECT_START = 2;
    private static final int ID_CLEARSTYLES = 16776962;
    private static final int ID_COPY = 16908321;
    private static final int ID_CUT = 16908320;
    private static final int ID_HIDEEDIT = 16776964;
    private static final int ID_HORIZONTALLINE = 16776961;
    private static final int ID_PASTE = 16908322;
    private static final int ID_SELECT_ALL = 16908319;
    private static final int ID_SHOWEDIT = 16776963;
    private static final int ID_START_SELECTING_TEXT = 16908328;
    private static final int ID_STOP_SELECTING_TEXT = 16908329;
    public static final char IMAGECHAR = 65532;
    private static final int MAXIMAGEWIDTHDIP = 300;
    public static final int MODE_ALIGN = 6;
    public static final int MODE_BGCOLOR = 16;
    public static final int MODE_CANCEL = 18;
    public static final int MODE_CLEARSTYLES = 14;
    public static final int MODE_COLOR = 4;
    public static final int MODE_COPY = 1;
    public static final int MODE_CUT = 7;
    public static final int MODE_END_EDIT = 21;
    public static final int MODE_HORIZONTALLINE = 12;
    public static final int MODE_IMAGE = 15;
    public static final int MODE_MARQUEE = 10;
    public static final int MODE_NOTHING = 0;
    public static final int MODE_PASTE = 2;
    public static final int MODE_PREVIEW = 17;
    public static final int MODE_RESET = 22;
    public static final int MODE_SELECT = 5;
    public static final int MODE_SELECTALL = 11;
    public static final int MODE_SHOW_MENU = 23;
    public static final int MODE_SIZE = 3;
    public static final int MODE_START_EDIT = 20;
    public static final int MODE_STOP_SELECT = 13;
    public static final int MODE_SWING = 9;
    public static final int MODE_TELOP = 8;
    public static final int MODE_TEXTVIEWFUNCTION = 19;
    private static final int PRESSED = 16777233;
    private static final NoCopySpan.Concrete SELECTING = null;
    public static final int STATE_SELECTED = 2;
    public static final int STATE_SELECT_FIX = 3;
    public static final int STATE_SELECT_OFF = 0;
    public static final int STATE_SELECT_ON = 1;
    private static CharSequence STR_CLEARSTYLES = null;
    private static CharSequence STR_HORIZONTALLINE = null;
    private static CharSequence STR_PASTE = null;
    private static final String TAG = "EditStyledText";
    public static final char ZEROWIDTHCHAR = 8288;
    private StyledTextConverter mConverter;
    private Drawable mDefaultBackground;
    private StyledTextDialog mDialog;
    private ArrayList<EditStyledTextNotifier> mESTNotifiers;
    private InputConnection mInputConnection;
    private EditorManager mManager;
    private float mPaddingScale;

    /* JADX INFO: renamed from: com.android.ex.editstyledtext.EditStyledText$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class ColorPaletteDrawable extends ShapeDrawable {
        private Rect mRect;

        public ColorPaletteDrawable(int r2, int r3, int r4, int r5) {
            super(new RectShape());
            this.mRect = new Rect(r5, r5, r3 - r5, r4 - r5);
            getPaint().setColor(r2);
        }

        @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas r2) {
            r2.drawRect(this.mRect, getPaint());
        }
    }

    public class EditModeActions {
        private static final boolean DBG = true;
        private static final String TAG = "EditModeActions";
        private HashMap<Integer, EditModeActionBase> mActionMap;
        private AlignAction mAlignAction;
        private BackgroundColorAction mBackgroundColorAction;
        private CancelAction mCancelEditAction;
        private ClearStylesAction mClearStylesAction;
        private ColorAction mColorAction;
        private CopyAction mCopyAction;
        private CutAction mCutAction;
        private StyledTextDialog mDialog;
        private EditStyledText mEST;
        private EndEditAction mEndEditAction;
        private HorizontalLineAction mHorizontalLineAction;
        private ImageAction mImageAction;
        private EditorManager mManager;
        private MarqueeDialogAction mMarqueeDialogAction;
        private int mMode;
        private NothingAction mNothingAction;
        private PasteAction mPasteAction;
        private PreviewAction mPreviewAction;
        private ResetAction mResetAction;
        private SelectAction mSelectAction;
        private SelectAllAction mSelectAllAction;
        private ShowMenuAction mShowMenuAction;
        private SizeAction mSizeAction;
        private StartEditAction mStartEditAction;
        private StopSelectionAction mStopSelectionAction;
        private SwingAction mSwingAction;
        private TelopAction mTelopAction;
        private TextViewAction mTextViewAction;
        final /* synthetic */ EditStyledText this$0;

        public class AlignAction extends SetSpanActionBase {
            final /* synthetic */ EditModeActions this$1;

            public AlignAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.SetSpanActionBase, com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doSelectionIsFixed() {
                if (super.doSelectionIsFixed() == false) goto L5;
                return true;
            L5:
                StyledTextDialog.access$4600(EditModeActions.access$3900(this.this$1));
                return true;
            }
        }

        public class BackgroundColorAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public BackgroundColorAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                StyledTextDialog.access$4000(EditModeActions.access$3900(this.this$1));
                return true;
            }
        }

        public class CancelAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public CancelAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                EditStyledText.access$3500(EditModeActions.access$1800(this.this$1));
                return true;
            }
        }

        public class ClearStylesAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public ClearStylesAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                EditorManager.access$3300(EditModeActions.access$2000(this.this$1));
                return true;
            }
        }

        public class ColorAction extends SetSpanActionBase {
            final /* synthetic */ EditModeActions this$1;

            public ColorAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.SetSpanActionBase, com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doSelectionIsFixed() {
                if (super.doSelectionIsFixed() == false) goto L5;
                return true;
            L5:
                StyledTextDialog.access$4800(EditModeActions.access$3900(this.this$1));
                return true;
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doSelectionIsFixedAndWaitingInput() {
                if (super.doSelectionIsFixedAndWaitingInput() == false) goto L5;
                return true;
            L5:
                int r0 = EditModeActions.access$2000(this.this$1).getSizeWaitInput();
                EditModeActions.access$2000(this.this$1).setItemColor(EditModeActions.access$2000(this.this$1).getColorWaitInput(), false);
                if (EditModeActions.access$2000(this.this$1).isWaitInput() == true) goto L8;
                EditModeActions.access$2000(this.this$1).setItemSize(r0, false);
                EditorManager.access$2400(EditModeActions.access$2000(this.this$1));
            L9:
                return true;
            L8:
                fixSelection();
                StyledTextDialog.access$4800(EditModeActions.access$3900(this.this$1));
                goto L9
            }
        }

        public class CopyAction extends TextViewActionBase {
            final /* synthetic */ EditModeActions this$1;

            public CopyAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.TextViewActionBase, com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doEndPosIsSelected() {
                if (super.doEndPosIsSelected() == false) goto L5;
                return true;
            L5:
                EditorManager.access$2500(EditModeActions.access$2000(this.this$1));
                EditorManager.access$2400(EditModeActions.access$2000(this.this$1));
                return true;
            }
        }

        public class CutAction extends TextViewActionBase {
            final /* synthetic */ EditModeActions this$1;

            public CutAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.TextViewActionBase, com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doEndPosIsSelected() {
                if (super.doEndPosIsSelected() == false) goto L5;
                return true;
            L5:
                EditorManager.access$2600(EditModeActions.access$2000(this.this$1));
                EditorManager.access$2400(EditModeActions.access$2000(this.this$1));
                return true;
            }
        }

        public class EditModeActionBase {
            private Object[] mParams;
            final /* synthetic */ EditModeActions this$1;

            protected boolean canOverWrap() {
                return false;
            }

            protected boolean canSelect() {
                return false;
            }

            protected boolean canWaitInput() {
                return false;
            }

            protected boolean doNotSelected() {
                return false;
            }

            protected boolean isLine() {
                return false;
            }

            protected boolean needSelection() {
                return false;
            }

            public EditModeActionBase(EditModeActions r1) {
                this.this$1 = r1;
            }

            protected boolean doStartPosIsSelected() {
                return doNotSelected();
            }

            protected boolean doEndPosIsSelected() {
                return doStartPosIsSelected();
            }

            protected boolean doSelectionIsFixed() {
                return doEndPosIsSelected();
            }

            protected boolean doSelectionIsFixedAndWaitingInput() {
                return doEndPosIsSelected();
            }

            protected boolean fixSelection() {
                EditStyledText.access$1900(EditModeActions.access$1800(this.this$1));
                EditorManager.access$2100(EditModeActions.access$2000(this.this$1), 3);
                return true;
            }

            protected void addParams(Object[] r1) {
                this.mParams = r1;
            }

            protected Object getParam(int r2) {
                Object[] r1 = this.mParams;
                if (r1 != null) goto L5;
            L9:
                Log.d(EditModeActions.TAG, "--- Number of the parameter is out of bound.");
                return null;
            L5:
                if (r2 > r1.length) goto L9;
                return r1[r2];
            }
        }

        public class EndEditAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public EndEditAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                EditorManager.access$4300(EditModeActions.access$2000(this.this$1));
                return true;
            }
        }

        public class HorizontalLineAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public HorizontalLineAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                EditorManager.access$3200(EditModeActions.access$2000(this.this$1));
                return true;
            }
        }

        public class ImageAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public ImageAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                Object r0 = getParam(0);
                if (r0 != null) goto L5;
                EditStyledText.access$3800(EditModeActions.access$1800(this.this$1));
                return true;
            L5:
                if ((r0 instanceof Uri) == false) goto L8;
                EditorManager.access$3600(EditModeActions.access$2000(this.this$1), (Uri) r0);
                return true;
            L8:
                if ((r0 instanceof Integer) == false) goto L14;
                EditorManager.access$3700(EditModeActions.access$2000(this.this$1), ((Integer) r0).intValue());
                return true;
            L14:
                return true;
            }
        }

        public class MarqueeDialogAction extends SetSpanActionBase {
            final /* synthetic */ EditModeActions this$1;

            public MarqueeDialogAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.SetSpanActionBase, com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doSelectionIsFixed() {
                if (super.doSelectionIsFixed() == false) goto L5;
                return true;
            L5:
                StyledTextDialog.access$4700(EditModeActions.access$3900(this.this$1));
                return true;
            }
        }

        public class NothingAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public NothingAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }
        }

        public class PasteAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public PasteAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                EditorManager.access$3000(EditModeActions.access$2000(this.this$1));
                EditorManager.access$2400(EditModeActions.access$2000(this.this$1));
                return true;
            }
        }

        public class PreviewAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public PreviewAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                EditStyledText.access$4100(EditModeActions.access$1800(this.this$1));
                return true;
            }
        }

        public class ResetAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public ResetAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                EditorManager.access$2400(EditModeActions.access$2000(this.this$1));
                return true;
            }
        }

        public class SelectAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doSelectionIsFixed() {
                return false;
            }

            public SelectAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                if (EditorManager.access$2700(EditModeActions.access$2000(this.this$1)) == false) goto L5;
                Log.e(EditModeActions.TAG, "Selection is off, but selected");
            L5:
                EditorManager.access$2800(EditModeActions.access$2000(this.this$1));
                EditStyledText.access$900(EditModeActions.access$1800(this.this$1), 3);
                return true;
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doStartPosIsSelected() {
                if (EditorManager.access$2700(EditModeActions.access$2000(this.this$1)) == false) goto L5;
                Log.e(EditModeActions.TAG, "Selection now start, but selected");
            L5:
                EditorManager.access$2900(EditModeActions.access$2000(this.this$1));
                EditStyledText.access$900(EditModeActions.access$1800(this.this$1), 4);
                if (EditModeActions.access$2000(this.this$1).getEditMode() == 5) goto L10;
                EditModeActions r2 = this.this$1;
                r2.doNext(EditModeActions.access$2000(r2).getEditMode());
                return true;
            L10:
                return true;
            }
        }

        public class SelectAllAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public SelectAllAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                EditorManager.access$3100(EditModeActions.access$2000(this.this$1));
                return true;
            }
        }

        public class SetSpanActionBase extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public SetSpanActionBase(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                if (EditModeActions.access$2000(this.this$1).getEditMode() != 0) goto L5;
            L16:
                EditorManager.access$2300(EditModeActions.access$2000(this.this$1), EditModeActions.access$2200(this.this$1));
                EditorManager.access$4500(EditModeActions.access$2000(this.this$1), EditModeActions.access$1800(this.this$1).getSelectionStart(), EditModeActions.access$1800(this.this$1).getSelectionEnd());
                fixSelection();
                this.this$1.doNext();
                return true;
            L5:
                if (EditModeActions.access$2000(this.this$1).getEditMode() == 5) goto L16;
                if (EditModeActions.access$2000(this.this$1).getEditMode() == EditModeActions.access$2200(this.this$1)) goto L15;
                Log.d(EditModeActions.TAG, "--- setspanactionbase" + EditModeActions.access$2000(this.this$1).getEditMode() + SimContactsConstants.EMAIL_SEP + EditModeActions.access$2200(this.this$1));
                if (EditModeActions.access$2000(this.this$1).isWaitInput() == true) goto L12;
                EditorManager.access$2400(EditModeActions.access$2000(this.this$1));
                EditorManager.access$2300(EditModeActions.access$2000(this.this$1), EditModeActions.access$2200(this.this$1));
            L13:
                this.this$1.doNext();
                return true;
            L12:
                EditorManager.access$2300(EditModeActions.access$2000(this.this$1), 0);
                EditorManager.access$2100(EditModeActions.access$2000(this.this$1), 0);
                goto L13
            L15:
                return false;
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doStartPosIsSelected() {
                if (EditModeActions.access$2000(this.this$1).getEditMode() != 0) goto L5;
            L9:
                EditorManager.access$2300(EditModeActions.access$2000(this.this$1), EditModeActions.access$2200(this.this$1));
                this.this$1.onSelectAction();
                return true;
            L5:
                if (EditModeActions.access$2000(this.this$1).getEditMode() == 5) goto L9;
                return doNotSelected();
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doEndPosIsSelected() {
                if (EditModeActions.access$2000(this.this$1).getEditMode() != 0) goto L5;
            L9:
                EditorManager.access$2300(EditModeActions.access$2000(this.this$1), EditModeActions.access$2200(this.this$1));
                fixSelection();
                this.this$1.doNext();
                return true;
            L5:
                if (EditModeActions.access$2000(this.this$1).getEditMode() == 5) goto L9;
                return doStartPosIsSelected();
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doSelectionIsFixed() {
                if (doEndPosIsSelected() == false) goto L6;
                return true;
            L6:
                EditStyledText.access$900(EditModeActions.access$1800(this.this$1), 0);
                return false;
            }
        }

        public class ShowMenuAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public ShowMenuAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                EditStyledText.access$4400(EditModeActions.access$1800(this.this$1));
                return true;
            }
        }

        public class SizeAction extends SetSpanActionBase {
            final /* synthetic */ EditModeActions this$1;

            public SizeAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.SetSpanActionBase, com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doSelectionIsFixed() {
                if (super.doSelectionIsFixed() == false) goto L5;
                return true;
            L5:
                StyledTextDialog.access$4900(EditModeActions.access$3900(this.this$1));
                return true;
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doSelectionIsFixedAndWaitingInput() {
                if (super.doSelectionIsFixedAndWaitingInput() == false) goto L5;
                return true;
            L5:
                int r0 = EditModeActions.access$2000(this.this$1).getColorWaitInput();
                EditModeActions.access$2000(this.this$1).setItemSize(EditModeActions.access$2000(this.this$1).getSizeWaitInput(), false);
                if (EditModeActions.access$2000(this.this$1).isWaitInput() == true) goto L8;
                EditModeActions.access$2000(this.this$1).setItemColor(r0, false);
                EditorManager.access$2400(EditModeActions.access$2000(this.this$1));
            L9:
                return true;
            L8:
                fixSelection();
                StyledTextDialog.access$4900(EditModeActions.access$3900(this.this$1));
                goto L9
            }
        }

        public class StartEditAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public StartEditAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                EditorManager.access$4200(EditModeActions.access$2000(this.this$1));
                return true;
            }
        }

        public class StopSelectionAction extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public StopSelectionAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                EditorManager.access$3400(EditModeActions.access$2000(this.this$1));
                return true;
            }
        }

        public class SwingAction extends SetSpanActionBase {
            final /* synthetic */ EditModeActions this$1;

            public SwingAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.SetSpanActionBase, com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doSelectionIsFixed() {
                if (super.doSelectionIsFixed() == false) goto L5;
                return true;
            L5:
                EditModeActions.access$2000(this.this$1).setSwing();
                return true;
            }
        }

        public class TelopAction extends SetSpanActionBase {
            final /* synthetic */ EditModeActions this$1;

            public TelopAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.SetSpanActionBase, com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doSelectionIsFixed() {
                if (super.doSelectionIsFixed() == false) goto L5;
                return true;
            L5:
                EditModeActions.access$2000(this.this$1).setTelop();
                return true;
            }
        }

        public class TextViewAction extends TextViewActionBase {
            final /* synthetic */ EditModeActions this$1;

            public TextViewAction(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.TextViewActionBase, com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doEndPosIsSelected() {
                if (super.doEndPosIsSelected() == false) goto L5;
                return true;
            L5:
                Object r0 = getParam(0);
                if (r0 != null) goto L8;
            L10:
                EditorManager.access$2400(EditModeActions.access$2000(this.this$1));
                return true;
            L8:
                if ((r0 instanceof Integer) == false) goto L10;
                EditModeActions.access$1800(this.this$1).onTextContextMenuItem(((Integer) r0).intValue());
                goto L10
            }
        }

        public class TextViewActionBase extends EditModeActionBase {
            final /* synthetic */ EditModeActions this$1;

            public TextViewActionBase(EditModeActions r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doNotSelected() {
                if (EditModeActions.access$2000(this.this$1).getEditMode() != 0) goto L5;
            L9:
                EditorManager.access$2300(EditModeActions.access$2000(this.this$1), EditModeActions.access$2200(this.this$1));
                this.this$1.onSelectAction();
                return true;
            L5:
                if (EditModeActions.access$2000(this.this$1).getEditMode() == 5) goto L9;
                return false;
            }

            @Override // com.android.ex.editstyledtext.EditStyledText.EditModeActions.EditModeActionBase
            protected boolean doEndPosIsSelected() {
                if (EditModeActions.access$2000(this.this$1).getEditMode() != 0) goto L5;
            L13:
                EditorManager.access$2300(EditModeActions.access$2000(this.this$1), EditModeActions.access$2200(this.this$1));
                fixSelection();
                this.this$1.doNext();
                return true;
            L5:
                if (EditModeActions.access$2000(this.this$1).getEditMode() == 5) goto L13;
                if (EditModeActions.access$2000(this.this$1).getEditMode() == EditModeActions.access$2200(this.this$1)) goto L11;
                EditorManager.access$2400(EditModeActions.access$2000(this.this$1));
                EditorManager.access$2300(EditModeActions.access$2000(this.this$1), EditModeActions.access$2200(this.this$1));
                this.this$1.doNext();
                return true;
            L11:
                return false;
            }
        }

        static /* synthetic */ EditStyledText access$1800(EditModeActions r0) {
            return r0.mEST;
        }

        static /* synthetic */ EditorManager access$2000(EditModeActions r0) {
            return r0.mManager;
        }

        static /* synthetic */ int access$2200(EditModeActions r0) {
            return r0.mMode;
        }

        static /* synthetic */ StyledTextDialog access$3900(EditModeActions r0) {
            return r0.mDialog;
        }

        EditModeActions(EditStyledText r2, EditStyledText r3, EditorManager r4, StyledTextDialog r5) {
            this.this$0 = r2;
            this.mMode = 0;
            this.mActionMap = new HashMap();
            this.mNothingAction = new NothingAction(this);
            this.mCopyAction = new CopyAction(this);
            this.mPasteAction = new PasteAction(this);
            this.mSelectAction = new SelectAction(this);
            this.mCutAction = new CutAction(this);
            this.mSelectAllAction = new SelectAllAction(this);
            this.mHorizontalLineAction = new HorizontalLineAction(this);
            this.mStopSelectionAction = new StopSelectionAction(this);
            this.mClearStylesAction = new ClearStylesAction(this);
            this.mImageAction = new ImageAction(this);
            this.mBackgroundColorAction = new BackgroundColorAction(this);
            this.mPreviewAction = new PreviewAction(this);
            this.mCancelEditAction = new CancelAction(this);
            this.mTextViewAction = new TextViewAction(this);
            this.mStartEditAction = new StartEditAction(this);
            this.mEndEditAction = new EndEditAction(this);
            this.mResetAction = new ResetAction(this);
            this.mShowMenuAction = new ShowMenuAction(this);
            this.mAlignAction = new AlignAction(this);
            this.mTelopAction = new TelopAction(this);
            this.mSwingAction = new SwingAction(this);
            this.mMarqueeDialogAction = new MarqueeDialogAction(this);
            this.mColorAction = new ColorAction(this);
            this.mSizeAction = new SizeAction(this);
            this.mEST = r3;
            this.mManager = r4;
            this.mDialog = r5;
            this.mActionMap.put(0, this.mNothingAction);
            this.mActionMap.put(1, this.mCopyAction);
            this.mActionMap.put(2, this.mPasteAction);
            this.mActionMap.put(5, this.mSelectAction);
            this.mActionMap.put(7, this.mCutAction);
            this.mActionMap.put(11, this.mSelectAllAction);
            this.mActionMap.put(12, this.mHorizontalLineAction);
            this.mActionMap.put(13, this.mStopSelectionAction);
            this.mActionMap.put(14, this.mClearStylesAction);
            this.mActionMap.put(15, this.mImageAction);
            this.mActionMap.put(16, this.mBackgroundColorAction);
            this.mActionMap.put(17, this.mPreviewAction);
            this.mActionMap.put(18, this.mCancelEditAction);
            this.mActionMap.put(19, this.mTextViewAction);
            this.mActionMap.put(20, this.mStartEditAction);
            this.mActionMap.put(21, this.mEndEditAction);
            this.mActionMap.put(22, this.mResetAction);
            this.mActionMap.put(23, this.mShowMenuAction);
            this.mActionMap.put(6, this.mAlignAction);
            this.mActionMap.put(8, this.mTelopAction);
            this.mActionMap.put(9, this.mSwingAction);
            this.mActionMap.put(10, this.mMarqueeDialogAction);
            this.mActionMap.put(4, this.mColorAction);
            this.mActionMap.put(3, this.mSizeAction);
        }

        public void addAction(int r1, EditModeActionBase r2) {
            this.mActionMap.put(Integer.valueOf(r1), r2);
        }

        public void onAction(int r2, Object[] r3) {
            getAction(r2).addParams(r3);
            this.mMode = r2;
            doNext(r2);
        }

        public void onAction(int r3, Object r4) {
            onAction(r3, new Object[]{r4});
        }

        public void onAction(int r2) {
            onAction(r2, null);
        }

        public void onSelectAction() {
            doNext(5);
        }

        private EditModeActionBase getAction(int r3) {
            if (this.mActionMap.containsKey(Integer.valueOf(r3)) == true) goto L5;
            return null;
        L5:
            return this.mActionMap.get(Integer.valueOf(r3));
        }

        public boolean doNext() {
            return doNext(this.mMode);
        }

        public boolean doNext(int r4) {
            Log.d(TAG, "--- do the next action: " + r4 + SimContactsConstants.EMAIL_SEP + this.mManager.getSelectState());
            EditModeActionBase r5 = getAction(r4);
            if (r5 != null) goto L6;
            Log.e(TAG, "--- invalid action error.");
            return false;
        L6:
            int r1 = this.mManager.getSelectState();
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L16;
            return false;
        L16:
            if (this.mManager.isWaitInput() == false) goto L20;
            return r5.doSelectionIsFixedAndWaitingInput();
        L20:
            return r5.doSelectionIsFixed();
        L22:
            return r5.doEndPosIsSelected();
        L24:
            return r5.doStartPosIsSelected();
        L26:
            return r5.doNotSelected();
        }
    }

    public interface EditStyledTextNotifier {
        void cancelViewManager();

        boolean isButtonsFocused();

        void onStateChanged(int r1, int r2);

        void sendHintMsg(int r1);

        boolean sendOnTouchEvent(MotionEvent r1);

        boolean showInsertImageSelectAlertDialog();

        boolean showMenuAlertDialog();

        boolean showPreview();
    }

    public static class EditStyledTextSpans {
        private static final String LOG_TAG = "EditStyledTextSpan";

        public static class HorizontalLineDrawable extends ShapeDrawable {
            private static boolean DBG_HL = false;
            private Spannable mSpannable;
            private int mWidth;

            static {
            }

            public HorizontalLineDrawable(int r2, int r3, Spannable r4) {
                super(new RectShape());
                this.mSpannable = r4;
                this.mWidth = r3;
                renewColor(r2);
                renewBounds(r3);
            }

            @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas r6) {
                renewColor();
                r6.drawRect(new Rect(0, 9, this.mWidth, 11), getPaint());
            }

            public void renewBounds(int r3) {
                if (DBG_HL == false) goto L6;
                Log.d(EditStyledTextSpans.LOG_TAG, "--- renewBounds:" + r3);
            L6:
                if (r3 <= 20) goto L8;
                r3 = r3 - 20;
            L8:
                this.mWidth = r3;
                setBounds(0, 0, r3, 20);
            }

            private void renewColor(int r3) {
                if (DBG_HL == false) goto L5;
                Log.d(EditStyledTextSpans.LOG_TAG, "--- renewColor:" + r3);
            L5:
                getPaint().setColor(r3);
            }

            private void renewColor() {
                HorizontalLineSpan r0 = getParentSpan();
                Spannable r1 = this.mSpannable;
                ForegroundColorSpan[] r2 = (ForegroundColorSpan[]) r1.getSpans(r1.getSpanStart(r0), r1.getSpanEnd(r0), ForegroundColorSpan.class);
                if (DBG_HL == false) goto L6;
                Log.d(EditStyledTextSpans.LOG_TAG, "--- renewColor:" + r2.length);
            L6:
                if (r2.length <= 0) goto L9;
                renewColor(r2[r2.length - 1].getForegroundColor());
                return;
            }

            private HorizontalLineSpan getParentSpan() {
                Spannable r0 = this.mSpannable;
                int r3 = 0;
                HorizontalLineSpan[] r1 = (HorizontalLineSpan[]) r0.getSpans(0, r0.length(), HorizontalLineSpan.class);
                if (r1.length <= 0) goto L10;
                int r2 = r1.length;
            L5:
                if (r3 >= r2) goto L10;
                HorizontalLineSpan r4 = r1[r3];
                if (r4.getDrawable() == this) goto L8;
                r3 = r3 + 1;
                goto L5
            L8:
                return r4;
            L10:
                Log.e(EditStyledTextSpans.LOG_TAG, "---renewBounds: Couldn't find");
                return null;
            }
        }

        public static class HorizontalLineSpan extends DynamicDrawableSpan {
            HorizontalLineDrawable mDrawable;

            public HorizontalLineSpan(int r2, int r3, Spannable r4) {
                super(0);
                this.mDrawable = new HorizontalLineDrawable(r2, r3, r4);
            }

            @Override // android.text.style.DynamicDrawableSpan
            public Drawable getDrawable() {
                return this.mDrawable;
            }

            public void resetWidth(int r1) {
                this.mDrawable.renewBounds(r1);
            }

            public int getColor() {
                return this.mDrawable.getPaint().getColor();
            }
        }

        public static class MarqueeSpan extends CharacterStyle {
            public static final int ALTERNATE = 1;
            public static final int NOTHING = 2;
            public static final int SCROLL = 0;
            private int mMarqueeColor;
            private int mType;

            public MarqueeSpan(int r1, int r2) {
                this.mType = r1;
                checkType(r1);
                this.mMarqueeColor = getMarqueeColor(r1, r2);
            }

            public MarqueeSpan(int r2) {
                this(r2, 16777215);
            }

            public int getType() {
                return this.mType;
            }

            public void resetColor(int r2) {
                this.mMarqueeColor = getMarqueeColor(this.mType, r2);
            }

            private int getMarqueeColor(int r6, int r7) {
                int r5 = Color.alpha(r7);
                int r0 = Color.red(r7);
                int r1 = Color.green(r7);
                int r8 = Color.blue(r7);
                if (r5 != 0) goto L6;
                r5 = 128;
            L6:
                if (r6 != 0) goto L8;
                if (r0 <= 128) goto L18;
                r0 = r0 / 2;
            L20:
                return Color.argb(r5, r0, r1, r8);
            L18:
                r0 = (255 - r0) / 2;
                goto L20
            L8:
                if (r6 != 1) goto L10;
                if (r1 <= 128) goto L15;
                r1 = r1 / 2;
                goto L20
            L15:
                r1 = (255 - r1) / 2;
                goto L20
            L10:
                if (r6 == 2) goto L12;
                Log.e(EditStyledText.TAG, "--- getMarqueeColor: got illigal marquee ID.");
            L12:
                return 16777215;
            }

            private boolean checkType(int r1) {
                if (r1 == 0) goto L8;
                if (r1 == 1) goto L9;
                Log.e(EditStyledTextSpans.LOG_TAG, "--- Invalid type of MarqueeSpan");
                return false;
            L9:
                return true;
            L8:
                return true;
            }

            @Override // android.text.style.CharacterStyle
            public void updateDrawState(TextPaint r1) {
                r1.bgColor = this.mMarqueeColor;
            }
        }

        public static class RescalableImageSpan extends ImageSpan {
            private final int MAXWIDTH;
            Uri mContentUri;
            private Context mContext;
            private Drawable mDrawable;
            public int mIntrinsicHeight;
            public int mIntrinsicWidth;

            public RescalableImageSpan(Context r2, Uri r3, int r4) {
                super(r2, r3);
                this.mIntrinsicWidth = -1;
                this.mIntrinsicHeight = -1;
                this.mContext = r2;
                this.mContentUri = r3;
                this.MAXWIDTH = r4;
            }

            public RescalableImageSpan(Context r1, int r2, int r3) {
                super(r1, r2);
                this.mIntrinsicWidth = -1;
                this.mIntrinsicHeight = -1;
                this.mContext = r1;
                this.MAXWIDTH = r3;
            }

            @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
            public Drawable getDrawable() {
                Drawable r1 = this.mDrawable;
                if (r1 == null) goto L6;
                return r1;
            L6:
                if (this.mContentUri == null) goto L19;
                System.gc();
                InputStream r2 = this.mContext.getContentResolver().openInputStream(this.mContentUri);     // Catch: OutOfMemoryError -> L14 Exception -> L16
                BitmapFactory.Options r3 = new BitmapFactory.Options();     // Catch: OutOfMemoryError -> L14 Exception -> L16
                r3.inJustDecodeBounds = true;     // Catch: OutOfMemoryError -> L14 Exception -> L16
                BitmapFactory.decodeStream(r2, null, r3);     // Catch: OutOfMemoryError -> L14 Exception -> L16
                r2.close();     // Catch: OutOfMemoryError -> L14 Exception -> L16
                InputStream r4 = this.mContext.getContentResolver().openInputStream(this.mContentUri);     // Catch: OutOfMemoryError -> L14 Exception -> L16
                int r5 = r3.outWidth;     // Catch: OutOfMemoryError -> L14 Exception -> L16
                int r6 = r3.outHeight;     // Catch: OutOfMemoryError -> L14 Exception -> L16
                this.mIntrinsicWidth = r5;     // Catch: OutOfMemoryError -> L14 Exception -> L16
                this.mIntrinsicHeight = r6;     // Catch: OutOfMemoryError -> L14 Exception -> L16
                int r7 = r3.outWidth;     // Catch: OutOfMemoryError -> L14 Exception -> L16
                int r8 = this.MAXWIDTH;     // Catch: OutOfMemoryError -> L14 Exception -> L16
                if (r7 <= r8) goto L11;
                r6 = (r6 * r8) / r3.outWidth;     // Catch: OutOfMemoryError -> L14 Exception -> L16
                Bitmap r9 = BitmapFactory.decodeStream(r4, new Rect(0, 0, r8, r6), null);     // Catch: OutOfMemoryError -> L14 Exception -> L16
                r5 = r8;
            L12:
                BitmapDrawable r10 = new BitmapDrawable(this.mContext.getResources(), r9);     // Catch: OutOfMemoryError -> L14 Exception -> L16
                this.mDrawable = r10;     // Catch: OutOfMemoryError -> L14 Exception -> L16
                r10.setBounds(0, 0, r5, r6);     // Catch: OutOfMemoryError -> L14 Exception -> L16
                r4.close();     // Catch: OutOfMemoryError -> L14 Exception -> L16
            L21:
                return this.mDrawable;
            L11:
                r9 = BitmapFactory.decodeStream(r4);     // Catch: OutOfMemoryError -> L14 Exception -> L16
            L16:
                e = move-exception;
                Log.e(EditStyledTextSpans.LOG_TAG, "Failed to loaded content " + this.mContentUri, e);
                return null;
            L14:
                Log.e(EditStyledTextSpans.LOG_TAG, "OutOfMemoryError");
                return null;
            L19:
                Drawable r0 = super.getDrawable();
                this.mDrawable = r0;
                rescaleBigImage(r0);
                this.mIntrinsicWidth = this.mDrawable.getIntrinsicWidth();
                this.mIntrinsicHeight = this.mDrawable.getIntrinsicHeight();
                goto L21
            }

            public boolean isOverSize() {
                if (getDrawable().getIntrinsicWidth() <= this.MAXWIDTH) goto L5;
                return true;
            L5:
                return false;
            }

            public Uri getContentUri() {
                return this.mContentUri;
            }

            private void rescaleBigImage(Drawable r6) {
                Log.d(EditStyledTextSpans.LOG_TAG, "--- rescaleBigImage:");
                if (this.MAXWIDTH >= 0) goto L5;
                return;
            L5:
                int r2 = r6.getIntrinsicWidth();
                int r3 = r6.getIntrinsicHeight();
                Log.d(EditStyledTextSpans.LOG_TAG, "--- rescaleBigImage:" + r2 + SimContactsConstants.EMAIL_SEP + r3 + SimContactsConstants.EMAIL_SEP + this.MAXWIDTH);
                int r5 = this.MAXWIDTH;
                if (r2 <= r5) goto L8;
                r3 = (r3 * r5) / r5;
                r2 = r5;
            L8:
                r6.setBounds(0, 0, r2, r3);
            }
        }

        public EditStyledTextSpans() {
        }
    }

    private class EditorManager {
        private static final String LOG_TAG = "EditStyledText.EditorManager";
        private EditModeActions mActions;
        private int mBackgroundColor;
        private int mColorWaitInput;
        private BackgroundColorSpan mComposingTextMask;
        private SpannableStringBuilder mCopyBuffer;
        private int mCurEnd;
        private int mCurStart;
        private EditStyledText mEST;
        private boolean mEditFlag;
        private boolean mKeepNonLineSpan;
        private int mMode;
        private int mSizeWaitInput;
        private SoftKeyReceiver mSkr;
        private boolean mSoftKeyBlockFlag;
        private int mState;
        private boolean mTextIsFinishedFlag;
        private boolean mWaitInputFlag;
        final /* synthetic */ EditStyledText this$0;

        static /* synthetic */ boolean access$200(EditorManager r0) {
            return r0.mTextIsFinishedFlag;
        }

        static /* synthetic */ boolean access$202(EditorManager r0, boolean r1) {
            r0.mTextIsFinishedFlag = r1;
            return r1;
        }

        static /* synthetic */ void access$2100(EditorManager r0, int r1) {
            r0.setSelectState(r1);
        }

        static /* synthetic */ void access$2300(EditorManager r0, int r1) {
            r0.setEditMode(r1);
        }

        static /* synthetic */ void access$2400(EditorManager r0) {
            r0.resetEdit();
        }

        static /* synthetic */ void access$2500(EditorManager r0) {
            r0.copyToClipBoard();
        }

        static /* synthetic */ void access$2600(EditorManager r0) {
            r0.cutToClipBoard();
        }

        static /* synthetic */ boolean access$2700(EditorManager r0) {
            return r0.isTextSelected();
        }

        static /* synthetic */ void access$2800(EditorManager r0) {
            r0.setSelectStartPos();
        }

        static /* synthetic */ void access$2900(EditorManager r0) {
            r0.setSelectEndPos();
        }

        static /* synthetic */ void access$3000(EditorManager r0) {
            r0.pasteFromClipboard();
        }

        static /* synthetic */ void access$3100(EditorManager r0) {
            r0.selectAll();
        }

        static /* synthetic */ void access$3200(EditorManager r0) {
            r0.insertHorizontalLine();
        }

        static /* synthetic */ void access$3300(EditorManager r0) {
            r0.clearStyles();
        }

        static /* synthetic */ void access$3400(EditorManager r0) {
            r0.fixSelectionAndDoNextAction();
        }

        static /* synthetic */ void access$3600(EditorManager r0, Uri r1) {
            r0.insertImageFromUri(r1);
        }

        static /* synthetic */ void access$3700(EditorManager r0, int r1) {
            r0.insertImageFromResId(r1);
        }

        static /* synthetic */ void access$4200(EditorManager r0) {
            r0.startEdit();
        }

        static /* synthetic */ void access$4300(EditorManager r0) {
            r0.endEdit();
        }

        static /* synthetic */ void access$4500(EditorManager r0, int r1, int r2) {
            r0.setInternalSelection(r1, r2);
        }

        EditorManager(EditStyledText r3, EditStyledText r4, StyledTextDialog r5) {
            this.this$0 = r3;
            this.mEditFlag = false;
            this.mSoftKeyBlockFlag = false;
            this.mKeepNonLineSpan = false;
            this.mWaitInputFlag = false;
            this.mTextIsFinishedFlag = false;
            this.mMode = 0;
            this.mState = 0;
            this.mCurStart = 0;
            this.mCurEnd = 0;
            this.mColorWaitInput = 16777215;
            this.mSizeWaitInput = 0;
            this.mBackgroundColor = 16777215;
            this.mEST = r4;
            this.mActions = new EditModeActions(r3, this.mEST, this, r5);
            this.mSkr = new SoftKeyReceiver(this.mEST);
        }

        public void addAction(int r1, EditModeActions.EditModeActionBase r2) {
            this.mActions.addAction(r1, r2);
        }

        public void onAction(int r2) {
            onAction(r2, true);
        }

        public void onAction(int r2, boolean r3) {
            this.mActions.onAction(r2);
            if (r3 == false) goto L6;
            EditStyledText.access$300(this.mEST, this.mMode, this.mState);
            return;
        }

        private void startEdit() {
            resetEdit();
            showSoftKey();
        }

        public void onStartSelect(boolean r3) {
            Log.d(LOG_TAG, "--- onClickSelect");
            this.mMode = 5;
            if (this.mState != 0) goto L5;
            this.mActions.onSelectAction();
        L6:
            if (r3 == false) goto L9;
            EditStyledText.access$300(this.mEST, this.mMode, this.mState);
            return;
        L9:
            return;
        L5:
            unsetSelect();
            this.mActions.onSelectAction();
            goto L6
        }

        public void onCursorMoved() {
            Log.d(LOG_TAG, "--- onClickView");
            int r0 = this.mState;
            if (r0 != 1) goto L5;
        L6:
            this.mActions.onSelectAction();
            EditStyledText.access$300(this.mEST, this.mMode, this.mState);
            return;
        L5:
            if (r0 == 2) goto L6;
        }

        public void onStartSelectAll(boolean r3) {
            Log.d(LOG_TAG, "--- onClickSelectAll");
            handleSelectAll();
            if (r3 == false) goto L6;
            EditStyledText.access$300(this.mEST, this.mMode, this.mState);
            return;
        }

        public void onStartShowMenuAlertDialog() {
            this.mActions.onAction(23);
        }

        public void onFixSelectedItem() {
            Log.d(LOG_TAG, "--- onFixSelectedItem");
            fixSelectionAndDoNextAction();
            EditStyledText.access$300(this.mEST, this.mMode, this.mState);
        }

        public void onInsertImage(Uri r3) {
            this.mActions.onAction(15, r3);
            EditStyledText.access$300(this.mEST, this.mMode, this.mState);
        }

        public void onInsertImage(int r3) {
            this.mActions.onAction(15, Integer.valueOf(r3));
            EditStyledText.access$300(this.mEST, this.mMode, this.mState);
        }

        private void insertImageFromUri(Uri r4) {
            insertImageSpan(new EditStyledTextSpans.RescalableImageSpan(this.mEST.getContext(), r4, EditStyledText.access$400(this.mEST)), this.mEST.getSelectionStart());
        }

        private void insertImageFromResId(int r4) {
            insertImageSpan(new EditStyledTextSpans.RescalableImageSpan(this.mEST.getContext(), r4, EditStyledText.access$500(this.mEST)), this.mEST.getSelectionStart());
        }

        private void insertHorizontalLine() {
            Log.d(LOG_TAG, "--- onInsertHorizontalLine:");
            int r0 = this.mEST.getSelectionStart();
            if (r0 > 0) goto L5;
        L7:
            int r3 = r0 + 1;
            insertImageSpan(new EditStyledTextSpans.HorizontalLineSpan(-16777216, this.mEST.getWidth(), this.mEST.getText()), r0);
            this.mEST.getText().insert(r3, "\n");
            this.mEST.setSelection(r3 + 1);
            EditStyledText.access$300(this.mEST, this.mMode, this.mState);
            return;
        L5:
            if (this.mEST.getText().charAt(r0 - 1) == '\n') goto L7;
            this.mEST.getText().insert(r0, "\n");
            r0 = r0 + 1;
            goto L7
        }

        private void clearStyles(CharSequence r7) {
            Log.d(EditStyledText.TAG, "--- onClearStyles");
            int r6 = r7.length();
            if ((r7 instanceof Editable) == false) goto L21;
            Editable r8 = (Editable) r7;
            int r1 = 0;
            Object[] r9 = r8.getSpans(0, r6, Object.class);
            int r0 = r9.length;
        L5:
            if (r1 >= r0) goto L26;
            Object r2 = r9[r1];
            if ((r2 instanceof ParagraphStyle) == true) goto L15;
            if ((r2 instanceof QuoteSpan) == true) goto L15;
            if ((r2 instanceof CharacterStyle) == false) goto L20;
            if ((r2 instanceof UnderlineSpan) == false) goto L15;
        L20:
            r1 = r1 + 1;
        L15:
            if ((r2 instanceof ImageSpan) == false) goto L17;
        L18:
            r8.replace(r8.getSpanStart(r2), r8.getSpanEnd(r2), "");
        L19:
            r8.removeSpan(r2);
            goto L20
        L17:
            if ((r2 instanceof EditStyledTextSpans.HorizontalLineSpan) == false) goto L19;
        L26:
            return;
        }

        public void onClearStyles() {
            this.mActions.onAction(14);
        }

        public void onCancelViewManagers() {
            this.mActions.onAction(18);
        }

        private void clearStyles() {
            Log.d(LOG_TAG, "--- onClearStyles");
            clearStyles(this.mEST.getText());
            EditStyledText r0 = this.mEST;
            r0.setBackgroundDrawable(EditStyledText.access$600(r0));
            this.mBackgroundColor = 16777215;
            onRefreshZeoWidthChar();
        }

        public void onRefreshZeoWidthChar() {
            Editable r3 = this.mEST.getText();
            int r0 = 0;
        L4:
            if (r0 >= r3.length()) goto L9;
            if (r3.charAt(r0) != 8288) goto L8;
            r3.replace(r0, r0 + 1, "");
            r0 = r0 - 1;
        L8:
            r0 = r0 + 1;
            goto L4
        }

        public void onRefreshStyles() {
            Log.d(LOG_TAG, "--- onRefreshStyles");
            Editable r0 = this.mEST.getText();
            int r1 = r0.length();
            int r2 = this.mEST.getWidth();
            EditStyledTextSpans.HorizontalLineSpan[] r3 = (EditStyledTextSpans.HorizontalLineSpan[]) r0.getSpans(0, r1, EditStyledTextSpans.HorizontalLineSpan.class);
            int r5 = r3.length;
            int r6 = 0;
        L3:
            if (r6 >= r5) goto L5;
            r3[r6].resetWidth(r2);
            r6 = r6 + 1;
            goto L3
        L5:
            EditStyledTextSpans.MarqueeSpan[] r4 = (EditStyledTextSpans.MarqueeSpan[]) r0.getSpans(0, r1, EditStyledTextSpans.MarqueeSpan.class);
            int r7 = r4.length;
            int r8 = 0;
        L6:
            if (r8 >= r7) goto L9;
            r4[r8].resetColor(this.mEST.getBackgroundColor());
            r8 = r8 + 1;
            goto L6
        L9:
            if (r3.length <= 0) goto L14;
            r0.replace(0, 1, "" + r0.charAt(0));
            return;
        }

        public void setBackgroundColor(int r1) {
            this.mBackgroundColor = r1;
        }

        public void setItemSize(int r3, boolean r4) {
            Log.d(LOG_TAG, "--- setItemSize");
            if (isWaitingNextAction() == false) goto L5;
            this.mSizeWaitInput = r3;
            return;
        L5:
            int r0 = this.mState;
            if (r0 != 2) goto L8;
        L9:
            if (r3 <= 0) goto L11;
            changeSizeSelectedText(r3);
        L11:
            if (r4 == false) goto L16;
            resetEdit();
            return;
        L16:
            return;
        L8:
            if (r0 == 3) goto L9;
        }

        public void setItemColor(int r3, boolean r4) {
            Log.d(LOG_TAG, "--- setItemColor");
            if (isWaitingNextAction() == false) goto L5;
            this.mColorWaitInput = r3;
            return;
        L5:
            int r0 = this.mState;
            if (r0 == 2) goto L10;
            if (r0 == 3) goto L10;
            return;
        L10:
            if (r3 == 16777215) goto L12;
            changeColorSelectedText(r3);
        L12:
            if (r4 == false) goto L17;
            resetEdit();
            return;
        }

        public void setAlignment(Layout.Alignment r3) {
            int r0 = this.mState;
            if (r0 != 2) goto L5;
        L6:
            changeAlign(r3);
            resetEdit();
            return;
        L5:
            if (r0 == 3) goto L6;
        }

        public void setTelop() {
            int r0 = this.mState;
            if (r0 != 2) goto L5;
        L6:
            addTelop();
            resetEdit();
            return;
        L5:
            if (r0 == 3) goto L6;
        }

        public void setSwing() {
            int r0 = this.mState;
            if (r0 != 2) goto L5;
        L6:
            addSwing();
            resetEdit();
            return;
        L5:
            if (r0 == 3) goto L6;
        }

        public void setMarquee(int r3) {
            int r0 = this.mState;
            if (r0 != 2) goto L5;
        L6:
            addMarquee(r3);
            resetEdit();
            return;
        L5:
            if (r0 == 3) goto L6;
        }

        public void setTextComposingMask(int r7, int r8) {
            Log.d(EditStyledText.TAG, "--- setTextComposingMask:" + r7 + SimContactsConstants.EMAIL_SEP + r8);
            int r0 = Math.min(r7, r8);
            int r9 = Math.max(r7, r8);
            if (isWaitInput() == false) goto L7;
            int r10 = this.mColorWaitInput;
            if (r10 == 16777215) goto L7;
        L8:
            int r3 = this.mEST.getBackgroundColor();
            Log.d(EditStyledText.TAG, "--- fg:" + Integer.toHexString(r10) + ",bg:" + Integer.toHexString(r3) + SimContactsConstants.EMAIL_SEP + isWaitInput() + ",," + this.mMode);
            if (r10 != r3) goto L17;
            int r11 = (~((-16777216) | r3)) | Integer.MIN_VALUE;
            BackgroundColorSpan r1 = this.mComposingTextMask;
            if (r1 != null) goto L13;
        L14:
            this.mComposingTextMask = new BackgroundColorSpan(r11);
        L15:
            this.mEST.getText().setSpan(this.mComposingTextMask, r0, r9, 33);
            return;
        L13:
            if (r1.getBackgroundColor() == r11) goto L15;
        L17:
            return;
        L7:
            r10 = this.mEST.getForegroundColor(r0);
            goto L8
        }

        private void setEditMode(int r1) {
            this.mMode = r1;
        }

        private void setSelectState(int r1) {
            this.mState = r1;
        }

        public void unsetTextComposingMask() {
            Log.d(EditStyledText.TAG, "--- unsetTextComposingMask");
            if (this.mComposingTextMask == null) goto L6;
            this.mEST.getText().removeSpan(this.mComposingTextMask);
            this.mComposingTextMask = null;
            return;
        }

        public boolean isEditting() {
            return this.mEditFlag;
        }

        public boolean isStyledText() {
            Editable r0 = this.mEST.getText();
            int r1 = r0.length();
            if (((ParagraphStyle[]) r0.getSpans(0, r1, ParagraphStyle.class)).length <= 0) goto L5;
            return true;
        L5:
            if (((QuoteSpan[]) r0.getSpans(0, r1, QuoteSpan.class)).length <= 0) goto L7;
            return true;
        L7:
            if (((CharacterStyle[]) r0.getSpans(0, r1, CharacterStyle.class)).length <= 0) goto L9;
            return true;
        L9:
            if (this.mBackgroundColor != 16777215) goto L16;
            return false;
        L16:
            return true;
        }

        public boolean isSoftKeyBlocked() {
            return this.mSoftKeyBlockFlag;
        }

        public boolean isWaitInput() {
            return this.mWaitInputFlag;
        }

        public int getBackgroundColor() {
            return this.mBackgroundColor;
        }

        public int getEditMode() {
            return this.mMode;
        }

        public int getSelectState() {
            return this.mState;
        }

        public int getSelectionStart() {
            return this.mCurStart;
        }

        public int getSelectionEnd() {
            return this.mCurEnd;
        }

        public int getSizeWaitInput() {
            return this.mSizeWaitInput;
        }

        public int getColorWaitInput() {
            return this.mColorWaitInput;
        }

        private void setInternalSelection(int r1, int r2) {
            this.mCurStart = r1;
            this.mCurEnd = r2;
        }

        public void updateSpanPreviousFromCursor(Editable r12, int r13, int r14, int r15) {
            Log.d(LOG_TAG, "updateSpanPrevious:" + r13 + SimContactsConstants.EMAIL_SEP + r14 + SimContactsConstants.EMAIL_SEP + r15);
            int r0 = r13 + r15;
            int r3 = Math.min(r13, r0);
            int r16 = Math.max(r13, r0);
            Object[] r4 = r12.getSpans(r3, r3, Object.class);
            int r5 = r4.length;
            int r6 = 0;
        L3:
            if (r6 >= r5) goto L37;
            Object r7 = r4[r6];
            if ((r7 instanceof ForegroundColorSpan) == false) goto L7;
        L24:
            int r8 = r12.getSpanStart(r7);
            int r9 = r12.getSpanEnd(r7);
            Log.d(LOG_TAG, "spantype:" + r7.getClass() + SimContactsConstants.EMAIL_SEP + r8);
            if ((r7 instanceof EditStyledTextSpans.MarqueeSpan) == false) goto L27;
        L33:
            int r10 = findLineEnd(this.mEST.getText(), r16);
        L34:
            if (r9 >= r10) goto L36;
            Log.d(LOG_TAG, "updateSpanPrevious: extend span");
            r12.setSpan(r7, r8, r10, 33);
        L36:
            r6 = r6 + 1;
            goto L3
        L27:
            if ((r7 instanceof AlignmentSpan) == true) goto L33;
            if (this.mKeepNonLineSpan == false) goto L32;
            r10 = r9;
            goto L34
        L32:
            r10 = r16;
            goto L34
        L7:
            if ((r7 instanceof AbsoluteSizeSpan) == true) goto L24;
            if ((r7 instanceof EditStyledTextSpans.MarqueeSpan) == true) goto L24;
            if ((r7 instanceof AlignmentSpan) == true) goto L24;
            if ((r7 instanceof EditStyledTextSpans.HorizontalLineSpan) == false) goto L36;
            int r11 = r12.getSpanStart(r7);
            int r17 = r12.getSpanEnd(r7);
            if (r14 <= r15) goto L18;
            r12.replace(r11, r17, "");
            r12.removeSpan(r7);
            goto L36
        L18:
            if (r17 != r0) goto L36;
            if (r0 >= r12.length()) goto L36;
            if (this.mEST.getText().charAt(r0) == '\n') goto L36;
            this.mEST.getText().insert(r0, "\n");
            goto L36
        }

        public void updateSpanNextToCursor(Editable r17, int r18, int r19, int r20) {
            Log.d(LOG_TAG, "updateSpanNext:" + r18 + SimContactsConstants.EMAIL_SEP + r19 + SimContactsConstants.EMAIL_SEP + r20);
            int r5 = r18 + r20;
            int r8 = Math.min(r18, r5);
            int r2 = Math.max(r18, r5);
            Object[] r3 = r17.getSpans(r2, r2, Object.class);
            int r9 = r3.length;
            int r10 = 0;
        L3:
            if (r10 >= r9) goto L31;
            Object r11 = r3[r10];
            boolean r12 = r11 instanceof EditStyledTextSpans.MarqueeSpan;
            if (r12 == false) goto L7;
        L18:
            int r13 = r17.getSpanStart(r11);
            int r14 = r17.getSpanEnd(r11);
            Object[] r110 = r3;
            Log.d(LOG_TAG, "spantype:" + r11.getClass() + SimContactsConstants.EMAIL_SEP + r14);
            if (r12 == false) goto L21;
        L24:
            int r4 = findLineStart(this.mEST.getText(), r8);
        L25:
            if (r4 >= r13) goto L28;
            if (r19 <= r20) goto L28;
            r17.removeSpan(r11);
        L30:
            r10 = r10 + 1;
            r3 = r110;
        L28:
            if (r13 <= r8) goto L30;
            r17.setSpan(r11, r8, r14, 33);
            goto L30
        L21:
            if ((r11 instanceof AlignmentSpan) == true) goto L24;
            r4 = r8;
            goto L25
        L7:
            if ((r11 instanceof AlignmentSpan) == true) goto L18;
            if ((r11 instanceof EditStyledTextSpans.HorizontalLineSpan) == true) goto L12;
        L17:
            r110 = r3;
            goto L30
        L12:
            if (r17.getSpanStart(r11) != r5) goto L17;
            if (r5 <= 0) goto L17;
            if (this.mEST.getText().charAt(r5 - 1) == '\n') goto L17;
            this.mEST.getText().insert(r5, "\n");
            this.mEST.setSelection(r5);
            goto L17
        }

        public boolean canPaste() {
            SpannableStringBuilder r0 = this.mCopyBuffer;
            if (r0 != null) goto L5;
        L9:
            return false;
        L5:
            if (r0.length() <= 0) goto L9;
            if (removeImageChar(this.mCopyBuffer).length() != 0) goto L9;
            return true;
        }

        private void endEdit() {
            Log.d(LOG_TAG, "--- handleCancel");
            this.mMode = 0;
            this.mState = 0;
            this.mEditFlag = false;
            this.mColorWaitInput = 16777215;
            this.mSizeWaitInput = 0;
            this.mWaitInputFlag = false;
            this.mSoftKeyBlockFlag = false;
            this.mKeepNonLineSpan = false;
            this.mTextIsFinishedFlag = false;
            unsetSelect();
            this.mEST.setOnClickListener(null);
            unblockSoftKey();
        }

        private void fixSelectionAndDoNextAction() {
            Log.d(LOG_TAG, "--- handleComplete:" + this.mCurStart + SimContactsConstants.EMAIL_SEP + this.mCurEnd);
            if (this.mEditFlag == true) goto L6;
            return;
        L6:
            if (this.mCurStart != this.mCurEnd) goto L10;
            Log.d(LOG_TAG, "--- cancel handle complete:" + this.mCurStart);
            resetEdit();
            return;
        L10:
            if (this.mState != 2) goto L12;
            this.mState = 3;
        L12:
            this.mActions.doNext(this.mMode);
            EditStyledText r3 = this.mEST;
            EditStyledText.access$700(r3, r3.getText());
        }

        private SpannableStringBuilder removeImageChar(SpannableStringBuilder r6) {
            SpannableStringBuilder r5 = new SpannableStringBuilder(r6);
            int r1 = 0;
            DynamicDrawableSpan[] r7 = (DynamicDrawableSpan[]) r5.getSpans(0, r5.length(), DynamicDrawableSpan.class);
            int r0 = r7.length;
        L3:
            if (r1 >= r0) goto L10;
            DynamicDrawableSpan r2 = r7[r1];
            if ((r2 instanceof EditStyledTextSpans.HorizontalLineSpan) == false) goto L7;
        L8:
            r5.replace(r5.getSpanStart(r2), r5.getSpanEnd(r2), "");
        L9:
            r1 = r1 + 1;
            goto L3
        L7:
            if ((r2 instanceof EditStyledTextSpans.RescalableImageSpan) == false) goto L9;
        L10:
            return r5;
        }

        private void copyToClipBoard() {
            int r0 = Math.min(getSelectionStart(), getSelectionEnd());
            int r1 = Math.max(getSelectionStart(), getSelectionEnd());
            SpannableStringBuilder r2 = (SpannableStringBuilder) this.mEST.getText().subSequence(r0, r1);
            this.mCopyBuffer = r2;
            SpannableStringBuilder r3 = removeImageChar(r2);
            ((ClipboardManager) this.this$0.getContext().getSystemService("clipboard")).setText(r3);
            dumpSpannableString(r3);
            dumpSpannableString(this.mCopyBuffer);
        }

        private void cutToClipBoard() {
            copyToClipBoard();
            int r0 = Math.min(getSelectionStart(), getSelectionEnd());
            int r1 = Math.max(getSelectionStart(), getSelectionEnd());
            this.mEST.getText().delete(r0, r1);
        }

        private boolean isClipBoardChanged(CharSequence r7) {
            Log.d(EditStyledText.TAG, "--- isClipBoardChanged:" + r7);
            if (this.mCopyBuffer != null) goto L5;
            return true;
        L5:
            int r0 = r7.length();
            SpannableStringBuilder r6 = removeImageChar(this.mCopyBuffer);
            Log.d(EditStyledText.TAG, "--- clipBoard:" + r0 + SimContactsConstants.EMAIL_SEP + r6 + r7);
            if (r0 == r6.length()) goto L8;
            return true;
        L8:
            int r3 = 0;
        L9:
            if (r3 >= r0) goto L14;
            if (r7.charAt(r3) != r6.charAt(r3)) goto L12;
            r3 = r3 + 1;
            goto L9
        L12:
            return true;
        L14:
            return false;
        }

        private void pasteFromClipboard() {
            int r0 = Math.min(this.mEST.getSelectionStart(), this.mEST.getSelectionEnd());
            int r1 = Math.max(this.mEST.getSelectionStart(), this.mEST.getSelectionEnd());
            Selection.setSelection(this.mEST.getText(), r1);
            ClipboardManager r2 = (ClipboardManager) this.this$0.getContext().getSystemService("clipboard");
            this.mKeepNonLineSpan = true;
            this.mEST.getText().replace(r0, r1, r2.getText());
            if (isClipBoardChanged(r2.getText()) == true) goto L13;
            Log.d(EditStyledText.TAG, "--- handlePaste: startPasteImage");
            SpannableStringBuilder r3 = this.mCopyBuffer;
            int r4 = 0;
            DynamicDrawableSpan[] r5 = (DynamicDrawableSpan[]) r3.getSpans(0, r3.length(), DynamicDrawableSpan.class);
            int r6 = r5.length;
        L5:
            if (r4 >= r6) goto L18;
            DynamicDrawableSpan r7 = r5[r4];
            int r8 = this.mCopyBuffer.getSpanStart(r7);
            if ((r7 instanceof EditStyledTextSpans.HorizontalLineSpan) == false) goto L10;
            insertImageSpan(new EditStyledTextSpans.HorizontalLineSpan(-16777216, this.mEST.getWidth(), this.mEST.getText()), r8 + r0);
        L12:
            r4 = r4 + 1;
            goto L5
        L10:
            if ((r7 instanceof EditStyledTextSpans.RescalableImageSpan) == false) goto L12;
            insertImageSpan(new EditStyledTextSpans.RescalableImageSpan(this.mEST.getContext(), ((EditStyledTextSpans.RescalableImageSpan) r7).getContentUri(), EditStyledText.access$400(this.mEST)), r8 + r0);
            goto L12
        L18:
            return;
        }

        private void handleSelectAll() {
            if (this.mEditFlag == true) goto L5;
            return;
        L5:
            this.mActions.onAction(11);
        }

        private void selectAll() {
            Selection.selectAll(this.mEST.getText());
            this.mCurStart = this.mEST.getSelectionStart();
            this.mCurEnd = this.mEST.getSelectionEnd();
            this.mMode = 5;
            this.mState = 3;
        }

        private void resetEdit() {
            endEdit();
            this.mEditFlag = true;
            EditStyledText.access$300(this.mEST, this.mMode, this.mState);
        }

        private void setSelection() {
            Log.d(LOG_TAG, "--- onSelect:" + this.mCurStart + SimContactsConstants.EMAIL_SEP + this.mCurEnd);
            int r0 = this.mCurStart;
            if (r0 >= 0) goto L5;
        L16:
            Log.e(LOG_TAG, "Select is on, but cursor positions are illigal.:" + this.mEST.getText().length() + SimContactsConstants.EMAIL_SEP + this.mCurStart + SimContactsConstants.EMAIL_SEP + this.mCurEnd);
            return;
        L5:
            if (r0 > this.mEST.getText().length()) goto L16;
            int r1 = this.mCurEnd;
            if (r1 < 0) goto L16;
            if (r1 > this.mEST.getText().length()) goto L16;
            int r2 = this.mCurStart;
            int r3 = this.mCurEnd;
            if (r2 >= r3) goto L13;
            this.mEST.setSelection(r2, r3);
            this.mState = 2;
            return;
        L13:
            if (r2 <= r3) goto L15;
            this.mEST.setSelection(r3, r2);
            this.mState = 2;
            return;
        L15:
            this.mState = 1;
        }

        private void unsetSelect() {
            Log.d(LOG_TAG, "--- offSelect");
            EditStyledText r0 = this.mEST;
            EditStyledText.access$700(r0, r0.getText());
            int r1 = this.mEST.getSelectionStart();
            this.mEST.setSelection(r1, r1);
            this.mState = 0;
        }

        private void setSelectStartPos() {
            Log.d(LOG_TAG, "--- setSelectStartPos");
            this.mCurStart = this.mEST.getSelectionStart();
            this.mState = 1;
        }

        private void setSelectEndPos() {
            if (this.mEST.getSelectionEnd() != this.mCurStart) goto L5;
            setEndPos(this.mEST.getSelectionStart());
            return;
        L5:
            setEndPos(this.mEST.getSelectionEnd());
        }

        public void setEndPos(int r3) {
            Log.d(LOG_TAG, "--- setSelectedEndPos:" + r3);
            this.mCurEnd = r3;
            setSelection();
        }

        private boolean isWaitingNextAction() {
            Log.d(LOG_TAG, "--- waitingNext:" + this.mCurStart + SimContactsConstants.EMAIL_SEP + this.mCurEnd + SimContactsConstants.EMAIL_SEP + this.mState);
            if (this.mCurStart == this.mCurEnd) goto L5;
        L8:
            resumeSelection();
            return false;
        L5:
            if (this.mState != 3) goto L8;
            waitSelection();
            return true;
        }

        private void waitSelection() {
            Log.d(LOG_TAG, "--- waitSelection");
            this.mWaitInputFlag = true;
            if (this.mCurStart != this.mCurEnd) goto L5;
            this.mState = 1;
        L6:
            EditStyledText r3 = this.mEST;
            EditStyledText.access$800(r3, r3.getText());
            return;
        L5:
            this.mState = 2;
            goto L6
        }

        private void resumeSelection() {
            Log.d(LOG_TAG, "--- resumeSelection");
            this.mWaitInputFlag = false;
            this.mState = 3;
            EditStyledText r2 = this.mEST;
            EditStyledText.access$700(r2, r2.getText());
        }

        private boolean isTextSelected() {
            int r1 = this.mState;
            if (r1 != 2) goto L5;
        L8:
            return true;
        L5:
            if (r1 == 3) goto L8;
            return false;
        }

        private void setStyledTextSpan(Object r3, int r4, int r5) {
            Log.d(LOG_TAG, "--- setStyledTextSpan:" + this.mMode + SimContactsConstants.EMAIL_SEP + r4 + SimContactsConstants.EMAIL_SEP + r5);
            int r0 = Math.min(r4, r5);
            int r6 = Math.max(r4, r5);
            this.mEST.getText().setSpan(r3, r0, r6, 33);
            Selection.setSelection(this.mEST.getText(), r6);
        }

        private void setLineStyledTextSpan(Object r6) {
            int r0 = Math.min(this.mCurStart, this.mCurEnd);
            int r1 = Math.max(this.mCurStart, this.mCurEnd);
            int r2 = this.mEST.getSelectionStart();
            int r3 = findLineStart(this.mEST.getText(), r0);
            int r4 = findLineEnd(this.mEST.getText(), r1);
            if (r3 != r4) goto L5;
            this.mEST.getText().insert(r4, "\n");
            setStyledTextSpan(r6, r3, r4 + 1);
        L6:
            Selection.setSelection(this.mEST.getText(), r2);
            return;
        L5:
            setStyledTextSpan(r6, r3, r4);
            goto L6
        }

        private void changeSizeSelectedText(int r3) {
            if (this.mCurStart == this.mCurEnd) goto L5;
            setStyledTextSpan(new AbsoluteSizeSpan(r3), this.mCurStart, this.mCurEnd);
            return;
        L5:
            Log.e(LOG_TAG, "---changeSize: Size of the span is zero");
        }

        private void changeColorSelectedText(int r3) {
            if (this.mCurStart == this.mCurEnd) goto L5;
            setStyledTextSpan(new ForegroundColorSpan(r3), this.mCurStart, this.mCurEnd);
            return;
        L5:
            Log.e(LOG_TAG, "---changeColor: Size of the span is zero");
        }

        private void changeAlign(Layout.Alignment r2) {
            setLineStyledTextSpan(new AlignmentSpan.Standard(r2));
        }

        private void addTelop() {
            addMarquee(1);
        }

        private void addSwing() {
            addMarquee(0);
        }

        private void addMarquee(int r3) {
            Log.d(LOG_TAG, "--- addMarquee:" + r3);
            setLineStyledTextSpan(new EditStyledTextSpans.MarqueeSpan(r3, this.mEST.getBackgroundColor()));
        }

        private void insertImageSpan(DynamicDrawableSpan r4, int r5) {
            Log.d(LOG_TAG, "--- insertImageSpan:");
            if (r4 != null) goto L5;
        L7:
            Log.e(LOG_TAG, "--- insertImageSpan: null span was inserted");
            EditStyledText.access$900(this.mEST, 5);
            return;
        L5:
            if (r4.getDrawable() == null) goto L7;
            this.mEST.getText().insert(r5, "￼");
            this.mEST.getText().setSpan(r4, r5, r5 + 1, 33);
            EditStyledText.access$300(this.mEST, this.mMode, this.mState);
        }

        private int findLineStart(Editable r3, int r4) {
            int r2 = r4;
        L3:
            if (r2 <= 0) goto L8;
            if (r3.charAt(r2 - 1) == '\n') goto L8;
            r2 = r2 - 1;
        L8:
            Log.d(LOG_TAG, "--- findLineStart:" + r4 + SimContactsConstants.EMAIL_SEP + r3.length() + SimContactsConstants.EMAIL_SEP + r2);
            return r2;
        }

        private int findLineEnd(Editable r3, int r4) {
            int r2 = r4;
        L4:
            if (r2 >= r3.length()) goto L9;
            if (r3.charAt(r2) == '\n') goto L7;
            r2 = r2 + 1;
            goto L4
        L7:
            r2 = r2 + 1;
        L9:
            Log.d(LOG_TAG, "--- findLineEnd:" + r4 + SimContactsConstants.EMAIL_SEP + r3.length() + SimContactsConstants.EMAIL_SEP + r2);
            return r2;
        }

        private void dumpSpannableString(CharSequence r8) {
            if ((r8 instanceof Spannable) == false) goto L7;
            Spannable r9 = (Spannable) r8;
            int r7 = r9.length();
            Log.d(EditStyledText.TAG, "--- dumpSpannableString, txt:" + r9 + ", len:" + r7);
            int r2 = 0;
            Object[] r10 = r9.getSpans(0, r7, Object.class);
            int r0 = r10.length;
        L5:
            if (r2 >= r0) goto L9;
            Object r3 = r10[r2];
            Log.d(EditStyledText.TAG, "--- dumpSpannableString, class:" + r3 + SimContactsConstants.EMAIL_SEP + r9.getSpanStart(r3) + SimContactsConstants.EMAIL_SEP + r9.getSpanEnd(r3) + SimContactsConstants.EMAIL_SEP + r9.getSpanFlags(r3));
            r2 = r2 + 1;
            goto L5
        L9:
            return;
        }

        public void showSoftKey() {
            showSoftKey(this.mEST.getSelectionStart(), this.mEST.getSelectionEnd());
        }

        public void showSoftKey(int r5, int r6) {
            Log.d(LOG_TAG, "--- showsoftkey");
            if (this.mEST.isFocused() == true) goto L5;
            return;
        L5:
            if (isSoftKeyBlocked() == true) goto L16;
            SoftKeyReceiver r0 = this.mSkr;
            r0.mNewStart = Selection.getSelectionStart(this.mEST.getText());
            SoftKeyReceiver r1 = this.mSkr;
            r1.mNewEnd = Selection.getSelectionEnd(this.mEST.getText());
            if (((InputMethodManager) this.this$0.getContext().getSystemService("input_method")).showSoftInput(this.mEST, 0, this.mSkr) == true) goto L10;
            return;
        L10:
            if (this.mSkr == null) goto L15;
            Selection.setSelection(this.this$0.getText(), r5, r6);
            return;
        L15:
            return;
        }

        public void hideSoftKey() {
            Log.d(LOG_TAG, "--- hidesoftkey");
            if (this.mEST.isFocused() == true) goto L5;
            return;
        L5:
            SoftKeyReceiver r0 = this.mSkr;
            r0.mNewStart = Selection.getSelectionStart(this.mEST.getText());
            SoftKeyReceiver r1 = this.mSkr;
            r1.mNewEnd = Selection.getSelectionEnd(this.mEST.getText());
            ((InputMethodManager) this.mEST.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mEST.getWindowToken(), 0, this.mSkr);
        }

        public void blockSoftKey() {
            Log.d(LOG_TAG, "--- blockSoftKey:");
            hideSoftKey();
            this.mSoftKeyBlockFlag = true;
        }

        public void unblockSoftKey() {
            Log.d(LOG_TAG, "--- unblockSoftKey:");
            this.mSoftKeyBlockFlag = false;
        }
    }

    private class MenuHandler implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ EditStyledText this$0;

        private MenuHandler(EditStyledText r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MenuHandler(EditStyledText r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r1) {
            return this.this$0.onTextContextMenuItem(r1.getItemId());
        }
    }

    public static class SavedStyledTextState extends View.BaseSavedState {
        public int mBackgroundColor;

        SavedStyledTextState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.mBackgroundColor);
        }

        public String toString() {
            return "EditStyledText.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " bgcolor=" + this.mBackgroundColor + "}";
        }
    }

    private static class SoftKeyReceiver extends ResultReceiver {
        EditStyledText mEST;
        int mNewEnd;
        int mNewStart;

        SoftKeyReceiver(EditStyledText r2) {
            super(r2.getHandler());
            this.mEST = r2;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int r1, Bundle r2) {
            if (r1 == 2) goto L6;
            Selection.setSelection(this.mEST.getText(), this.mNewStart, this.mNewEnd);
            return;
        }
    }

    private static class StyledTextArrowKeyMethod extends ArrowKeyMovementMethod {
        String LOG_TAG;
        EditorManager mManager;

        StyledTextArrowKeyMethod(EditorManager r2) {
            this.LOG_TAG = "StyledTextArrowKeyMethod";
            this.mManager = r2;
        }

        @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onKeyDown(TextView r4, Spannable r5, int r6, KeyEvent r7) {
            Log.d(this.LOG_TAG, "---onkeydown:" + r6);
            this.mManager.unsetTextComposingMask();
            if (this.mManager.getSelectState() == 1) goto L10;
            if (this.mManager.getSelectState() == 2) goto L10;
            return super.onKeyDown(r4, r5, r6, r7);
        L10:
            return executeDown(r4, r5, r6);
        }

        private int getEndPos(TextView r2) {
            if (r2.getSelectionStart() != this.mManager.getSelectionStart()) goto L6;
            return r2.getSelectionEnd();
        L6:
            return r2.getSelectionStart();
        }

        @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
        protected boolean up(TextView r5, Spannable r6) {
            Log.d(this.LOG_TAG, "--- up:");
            Layout r7 = r5.getLayout();
            int r8 = getEndPos(r5);
            int r0 = r7.getLineForOffset(r8);
            if (r0 <= 0) goto L9;
            int r2 = r7.getParagraphDirection(r0);
            int r1 = r0 - 1;
            if (r2 != r7.getParagraphDirection(r1)) goto L7;
            int r9 = r7.getOffsetForHorizontal(r1, r7.getPrimaryHorizontal(r8));
        L8:
            this.mManager.setEndPos(r9);
            this.mManager.onCursorMoved();
            goto L9
        L7:
            r9 = r7.getLineStart(r1);
        L9:
            return true;
        }

        @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
        protected boolean down(TextView r5, Spannable r6) {
            Log.d(this.LOG_TAG, "--- down:");
            Layout r7 = r5.getLayout();
            int r8 = getEndPos(r5);
            int r0 = r7.getLineForOffset(r8);
            if (r0 >= (r7.getLineCount() - 1)) goto L9;
            int r1 = r7.getParagraphDirection(r0);
            int r2 = r0 + 1;
            if (r1 != r7.getParagraphDirection(r2)) goto L7;
            int r9 = r7.getOffsetForHorizontal(r2, r7.getPrimaryHorizontal(r8));
        L8:
            this.mManager.setEndPos(r9);
            this.mManager.onCursorMoved();
            goto L9
        L7:
            r9 = r7.getLineStart(r2);
        L9:
            return true;
        }

        @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
        protected boolean left(TextView r2, Spannable r3) {
            Log.d(this.LOG_TAG, "--- left:");
            int r4 = r2.getLayout().getOffsetToLeftOf(getEndPos(r2));
            this.mManager.setEndPos(r4);
            this.mManager.onCursorMoved();
            return true;
        }

        @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
        protected boolean right(TextView r2, Spannable r3) {
            Log.d(this.LOG_TAG, "--- right:");
            int r4 = r2.getLayout().getOffsetToRightOf(getEndPos(r2));
            this.mManager.setEndPos(r4);
            this.mManager.onCursorMoved();
            return true;
        }

        private boolean executeDown(TextView r4, Spannable r5, int r6) {
            Log.d(this.LOG_TAG, "--- executeDown: " + r6);
            switch(r6) {
                case 19: goto L9;
                case 20: goto L8;
                case 21: goto L7;
                case 22: goto L6;
                case 23: goto L5;
                default: goto L13;
            };
        L5:
            this.mManager.onFixSelectedItem();
            return true;
        L6:
            boolean r3 = right(r4, r5);
        L11:
            return false | r3;
        L7:
            r3 = left(r4, r5);
            goto L11
        L8:
            r3 = down(r4, r5);
            goto L11
        L9:
            r3 = up(r4, r5);
            goto L11
        L13:
            return false;
        }
    }

    private class StyledTextConverter {
        private EditStyledText mEST;
        private StyledTextHtmlConverter mHtml;
        final /* synthetic */ EditStyledText this$0;

        static /* synthetic */ EditStyledText access$1200(StyledTextConverter r0) {
            return r0.mEST;
        }

        public StyledTextConverter(EditStyledText r1, EditStyledText r2, StyledTextHtmlConverter r3) {
            this.this$0 = r1;
            this.mEST = r2;
            this.mHtml = r3;
        }

        public void setStyledTextHtmlConverter(StyledTextHtmlConverter r1) {
            this.mHtml = r1;
        }

        public String getHtml(boolean r2) {
            this.mEST.clearComposingText();
            EditStyledText.access$1000(this.mEST);
            String r1 = this.mHtml.toHtml(this.mEST.getText(), r2);
            Log.d(EditStyledText.TAG, "--- getHtml:" + r1);
            return r1;
        }

        public String getPreviewHtml() {
            this.mEST.clearComposingText();
            EditStyledText.access$1000(this.mEST);
            String r0 = this.mHtml.toHtml(this.mEST.getText(), true, EditStyledText.access$500(this.this$0), EditStyledText.access$1100(this.this$0));
            int r1 = this.mEST.getBackgroundColor();
            String r2 = String.format("<body bgcolor=\"#%02X%02X%02X\">%s</body>", new Object[]{Integer.valueOf(Color.red(r1)), Integer.valueOf(Color.green(r1)), Integer.valueOf(Color.blue(r1)), r0});
            Log.d(EditStyledText.TAG, "--- getPreviewHtml:" + r2 + SimContactsConstants.EMAIL_SEP + this.mEST.getWidth());
            return r2;
        }

        public void getUriArray(ArrayList<Uri> r8, Editable r9) {
            r8.clear();
            Log.d(EditStyledText.TAG, "--- getUriArray:");
            int r7 = r9.length();
            int r2 = 0;
        L4:
            if (r2 >= r9.length()) goto L10;
            int r3 = r9.nextSpanTransition(r2, r7, ImageSpan.class);
            ImageSpan[] r4 = (ImageSpan[]) r9.getSpans(r2, r3, ImageSpan.class);
            int r5 = 0;
        L7:
            if (r5 >= r4.length) goto L9;
            Log.d(EditStyledText.TAG, "--- getUriArray: foundArray" + r4[r5].getSource());
            r8.add(Uri.parse(r4[r5].getSource()));
            r5 = r5 + 1;
            goto L7
        L9:
            r2 = r3;
            goto L4
        }

        public void SetHtml(String r4) {
            Spanned r5 = this.mHtml.fromHtml(r4, new AnonymousClass1(this), null);
            this.mEST.setText(r5);
        }
    }

    private static class StyledTextDialog {
        private static final int TYPE_BACKGROUND = 1;
        private static final int TYPE_FOREGROUND = 0;
        private AlertDialog mAlertDialog;
        private CharSequence[] mAlignNames;
        private CharSequence mAlignTitle;
        private AlertDialog.Builder mBuilder;
        private CharSequence mColorDefaultMessage;
        private CharSequence[] mColorInts;
        private CharSequence[] mColorNames;
        private CharSequence mColorTitle;
        private EditStyledText mEST;
        private CharSequence[] mMarqueeNames;
        private CharSequence mMarqueeTitle;
        private CharSequence[] mSizeDisplayInts;
        private CharSequence[] mSizeNames;
        private CharSequence[] mSizeSendInts;
        private CharSequence mSizeTitle;

        static /* synthetic */ EditStyledText access$1300(StyledTextDialog r0) {
            return r0.mEST;
        }

        static /* synthetic */ AlertDialog access$1500(StyledTextDialog r0) {
            return r0.mAlertDialog;
        }

        static /* synthetic */ AlertDialog access$1502(StyledTextDialog r0, AlertDialog r1) {
            r0.mAlertDialog = r1;
            return r1;
        }

        static /* synthetic */ CharSequence[] access$1600(StyledTextDialog r0) {
            return r0.mSizeDisplayInts;
        }

        static /* synthetic */ void access$4000(StyledTextDialog r0) {
            r0.onShowBackgroundColorAlertDialog();
        }

        static /* synthetic */ void access$4600(StyledTextDialog r0) {
            r0.onShowAlignAlertDialog();
        }

        static /* synthetic */ void access$4700(StyledTextDialog r0) {
            r0.onShowMarqueeAlertDialog();
        }

        static /* synthetic */ void access$4800(StyledTextDialog r0) {
            r0.onShowForegroundColorAlertDialog();
        }

        static /* synthetic */ void access$4900(StyledTextDialog r0) {
            r0.onShowSizeAlertDialog();
        }

        public StyledTextDialog(EditStyledText r1) {
            this.mEST = r1;
        }

        public void setBuilder(AlertDialog.Builder r1) {
            this.mBuilder = r1;
        }

        public void setColorAlertParams(CharSequence r1, CharSequence[] r2, CharSequence[] r3, CharSequence r4) {
            this.mColorTitle = r1;
            this.mColorNames = r2;
            this.mColorInts = r3;
            this.mColorDefaultMessage = r4;
        }

        public void setSizeAlertParams(CharSequence r1, CharSequence[] r2, CharSequence[] r3, CharSequence[] r4) {
            this.mSizeTitle = r1;
            this.mSizeNames = r2;
            this.mSizeDisplayInts = r3;
            this.mSizeSendInts = r4;
        }

        public void setAlignAlertParams(CharSequence r1, CharSequence[] r2) {
            this.mAlignTitle = r1;
            this.mAlignNames = r2;
        }

        public void setMarqueeAlertParams(CharSequence r1, CharSequence[] r2) {
            this.mMarqueeTitle = r1;
            this.mMarqueeNames = r2;
        }

        private boolean checkColorAlertParams() {
            Log.d(EditStyledText.TAG, "--- checkParams");
            if (this.mBuilder != null) goto L7;
            Log.e(EditStyledText.TAG, "--- builder is null.");
            return false;
        L7:
            if (this.mColorTitle == null) goto L19;
            CharSequence[] r0 = this.mColorNames;
            if (r0 == null) goto L19;
            CharSequence[] r3 = this.mColorInts;
            if (r3 == null) goto L19;
            if (r0.length == r3.length) goto L17;
            Log.e(EditStyledText.TAG, "--- the length of color alert params are different.");
            return false;
        L17:
            return true;
        L19:
            Log.e(EditStyledText.TAG, "--- color alert params are null.");
            return false;
        }

        private boolean checkSizeAlertParams() {
            Log.d(EditStyledText.TAG, "--- checkParams");
            if (this.mBuilder != null) goto L7;
            Log.e(EditStyledText.TAG, "--- builder is null.");
            return false;
        L7:
            if (this.mSizeTitle == null) goto L23;
            CharSequence[] r0 = this.mSizeNames;
            if (r0 == null) goto L23;
            CharSequence[] r3 = this.mSizeDisplayInts;
            if (r3 == null) goto L23;
            CharSequence[] r5 = this.mSizeSendInts;
            if (r5 == null) goto L23;
            if (r0.length != r3.length) goto L18;
            return true;
        L18:
            if (r5.length == r3.length) goto L25;
            Log.e(EditStyledText.TAG, "--- the length of size alert params are different.");
            return false;
        L25:
            return true;
        L23:
            Log.e(EditStyledText.TAG, "--- size alert params are null.");
            return false;
        }

        private boolean checkAlignAlertParams() {
            Log.d(EditStyledText.TAG, "--- checkAlignAlertParams");
            if (this.mBuilder != null) goto L7;
            Log.e(EditStyledText.TAG, "--- builder is null.");
            return false;
        L7:
            if (this.mAlignTitle != null) goto L10;
            Log.e(EditStyledText.TAG, "--- align alert params are null.");
            return false;
        L10:
            return true;
        }

        private boolean checkMarqueeAlertParams() {
            Log.d(EditStyledText.TAG, "--- checkMarqueeAlertParams");
            if (this.mBuilder != null) goto L7;
            Log.e(EditStyledText.TAG, "--- builder is null.");
            return false;
        L7:
            if (this.mMarqueeTitle != null) goto L10;
            Log.e(EditStyledText.TAG, "--- Marquee alert params are null.");
            return false;
        L10:
            return true;
        }

        private void buildDialogue(CharSequence r4, CharSequence[] r5, DialogInterface.OnClickListener r6) {
            this.mBuilder.setTitle(r4);
            this.mBuilder.setIcon(0);
            this.mBuilder.setPositiveButton(null, null);
            this.mBuilder.setNegativeButton(R.string.cancel, new AnonymousClass1(this));
            this.mBuilder.setItems(r5, r6);
            this.mBuilder.setView(null);
            this.mBuilder.setCancelable(true);
            this.mBuilder.setOnCancelListener(new AnonymousClass2(this));
            this.mBuilder.show();
        }

        private void buildAndShowColorDialogue(int r9, CharSequence r10, int[] r11) {
            int r0 = EditStyledText.access$1400(this.mEST, 50);
            int r1 = EditStyledText.access$1400(this.mEST, 2);
            int r2 = EditStyledText.access$1400(this.mEST, 15);
            this.mBuilder.setTitle(r10);
            int r3 = 0;
            this.mBuilder.setIcon(0);
            LinearLayout r4 = null;
            this.mBuilder.setPositiveButton(null, null);
            this.mBuilder.setNegativeButton(R.string.cancel, new AnonymousClass3(this));
            this.mBuilder.setItems(null, null);
            LinearLayout r12 = new LinearLayout(this.mEST.getContext());
            r12.setOrientation(1);
            r12.setGravity(1);
            r12.setPadding(r2, r2, r2, r2);
        L4:
            if (r3 >= r11.length) goto L14;
            if ((r3 % 5) != 0) goto L8;
            LinearLayout r5 = new LinearLayout(this.mEST.getContext());
            r12.addView(r5);
            r4 = r5;
        L8:
            Button r6 = new Button(this.mEST.getContext());
            r6.setHeight(r0);
            r6.setWidth(r0);
            r6.setBackgroundDrawable(new ColorPaletteDrawable(r11[r3], r0, r0, r1));
            r6.setDrawingCacheBackgroundColor(r11[r3]);
            if (r9 != 0) goto L11;
            r6.setOnClickListener(new AnonymousClass4(this));
        L13:
            r4.addView(r6);
            r3 = r3 + 1;
            goto L4
        L11:
            if (r9 != 1) goto L13;
            r6.setOnClickListener(new AnonymousClass5(this));
            goto L13
        L14:
            if (r9 != 1) goto L16;
            this.mBuilder.setPositiveButton(this.mColorDefaultMessage, new AnonymousClass6(this));
        L18:
            this.mBuilder.setView(r12);
            this.mBuilder.setCancelable(true);
            this.mBuilder.setOnCancelListener(new AnonymousClass8(this));
            this.mAlertDialog = this.mBuilder.show();
            return;
        L16:
            if (r9 != 0) goto L18;
            this.mBuilder.setPositiveButton(this.mColorDefaultMessage, new AnonymousClass7(this));
            goto L18
        }

        private void onShowForegroundColorAlertDialog() {
            Log.d(EditStyledText.TAG, "--- onShowForegroundColorAlertDialog");
            if (checkColorAlertParams() == true) goto L5;
            return;
        L5:
            int r0 = this.mColorInts.length;
            int[] r1 = new int[r0];
            int r3 = 0;
        L6:
            if (r3 >= r0) goto L8;
            r1[r3] = Integer.parseInt((String) this.mColorInts[r3], 16) - 16777216;
            r3 = r3 + 1;
            goto L6
        L8:
            buildAndShowColorDialogue(0, this.mColorTitle, r1);
        }

        private void onShowBackgroundColorAlertDialog() {
            Log.d(EditStyledText.TAG, "--- onShowBackgroundColorAlertDialog");
            if (checkColorAlertParams() == true) goto L5;
            return;
        L5:
            int r0 = this.mColorInts.length;
            int[] r1 = new int[r0];
            int r2 = 0;
        L6:
            if (r2 >= r0) goto L8;
            r1[r2] = Integer.parseInt((String) this.mColorInts[r2], 16) - 16777216;
            r2 = r2 + 1;
            goto L6
        L8:
            buildAndShowColorDialogue(1, this.mColorTitle, r1);
        }

        private void onShowSizeAlertDialog() {
            Log.d(EditStyledText.TAG, "--- onShowSizeAlertDialog");
            if (checkSizeAlertParams() == true) goto L5;
            return;
        L5:
            buildDialogue(this.mSizeTitle, this.mSizeNames, new AnonymousClass9(this));
        }

        private void onShowAlignAlertDialog() {
            Log.d(EditStyledText.TAG, "--- onShowAlignAlertDialog");
            if (checkAlignAlertParams() == true) goto L5;
            return;
        L5:
            buildDialogue(this.mAlignTitle, this.mAlignNames, new AnonymousClass10(this));
        }

        private void onShowMarqueeAlertDialog() {
            Log.d(EditStyledText.TAG, "--- onShowMarqueeAlertDialog");
            if (checkMarqueeAlertParams() == true) goto L5;
            return;
        L5:
            buildDialogue(this.mMarqueeTitle, this.mMarqueeNames, new AnonymousClass11(this));
        }
    }

    public interface StyledTextHtmlConverter {
        Spanned fromHtml(String r1);

        Spanned fromHtml(String r1, Html.ImageGetter r2, Html.TagHandler r3);

        String toHtml(Spanned r1);

        String toHtml(Spanned r1, boolean r2);

        String toHtml(Spanned r1, boolean r2, int r3, float r4);
    }

    private class StyledTextHtmlStandard implements StyledTextHtmlConverter {
        final /* synthetic */ EditStyledText this$0;

        private StyledTextHtmlStandard(EditStyledText r1) {
            this.this$0 = r1;
        }

        /* synthetic */ StyledTextHtmlStandard(EditStyledText r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.ex.editstyledtext.EditStyledText.StyledTextHtmlConverter
        public String toHtml(Spanned r1) {
            return Html.toHtml(r1);
        }

        @Override // com.android.ex.editstyledtext.EditStyledText.StyledTextHtmlConverter
        public String toHtml(Spanned r1, boolean r2) {
            return Html.toHtml(r1);
        }

        @Override // com.android.ex.editstyledtext.EditStyledText.StyledTextHtmlConverter
        public String toHtml(Spanned r1, boolean r2, int r3, float r4) {
            return Html.toHtml(r1);
        }

        @Override // com.android.ex.editstyledtext.EditStyledText.StyledTextHtmlConverter
        public Spanned fromHtml(String r1) {
            return Html.fromHtml(r1);
        }

        @Override // com.android.ex.editstyledtext.EditStyledText.StyledTextHtmlConverter
        public Spanned fromHtml(String r1, Html.ImageGetter r2, Html.TagHandler r3) {
            return Html.fromHtml(r1, r2, r3);
        }
    }

    public static class StyledTextInputConnection extends InputConnectionWrapper {
        EditStyledText mEST;

        public StyledTextInputConnection(InputConnection r2, EditStyledText r3) {
            super(r2, true);
            this.mEST = r3;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence r3, int r4) {
            Log.d(EditStyledText.TAG, "--- commitText:");
            EditStyledText.access$1700(this.mEST).unsetTextComposingMask();
            return super.commitText(r3, r4);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean finishComposingText() {
            Log.d(EditStyledText.TAG, "--- finishcomposing:");
            if (this.mEST.isSoftKeyBlocked() == true) goto L10;
            if (this.mEST.isButtonsFocused() == true) goto L10;
            if (this.mEST.isEditting() == true) goto L10;
            this.mEST.onEndEdit();
        L10:
            return super.finishComposingText();
        }
    }

    private int getMaxImageWidthDip() {
        return 300;
    }

    static /* synthetic */ void access$1000(EditStyledText r0) {
        r0.onRefreshZeoWidthChar();
    }

    static /* synthetic */ float access$1100(EditStyledText r0) {
        return r0.getPaddingScale();
    }

    static /* synthetic */ int access$1400(EditStyledText r0, int r1) {
        return r0.dipToPx(r1);
    }

    static /* synthetic */ EditorManager access$1700(EditStyledText r0) {
        return r0.mManager;
    }

    static /* synthetic */ void access$1900(EditStyledText r0) {
        r0.finishComposingText();
    }

    static /* synthetic */ void access$300(EditStyledText r0, int r1, int r2) {
        r0.notifyStateChanged(r1, r2);
    }

    static /* synthetic */ void access$3500(EditStyledText r0) {
        r0.cancelViewManagers();
    }

    static /* synthetic */ void access$3800(EditStyledText r0) {
        r0.showInsertImageSelectAlertDialog();
    }

    static /* synthetic */ int access$400(EditStyledText r0) {
        return r0.getMaxImageWidthPx();
    }

    static /* synthetic */ void access$4100(EditStyledText r0) {
        r0.showPreview();
    }

    static /* synthetic */ void access$4400(EditStyledText r0) {
        r0.showMenuAlertDialog();
    }

    static /* synthetic */ int access$500(EditStyledText r0) {
        return r0.getMaxImageWidthDip();
    }

    static /* synthetic */ Drawable access$600(EditStyledText r0) {
        return r0.mDefaultBackground;
    }

    static /* synthetic */ void access$700(View r0, Spannable r1) {
        stopSelecting(r0, r1);
    }

    static /* synthetic */ void access$800(View r0, Spannable r1) {
        startSelecting(r0, r1);
    }

    static /* synthetic */ void access$900(EditStyledText r0, int r1) {
        r0.sendHintMessage(r1);
    }

    static {
        SELECTING = new NoCopySpan.Concrete();
    }

    public EditStyledText(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mPaddingScale = 0.0f;
        init();
    }

    public EditStyledText(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mPaddingScale = 0.0f;
        init();
    }

    public EditStyledText(Context r1) {
        super(r1);
        this.mPaddingScale = 0.0f;
        init();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        if (r6.getAction() != 1) goto L15;
        cancelLongPress();
        boolean r0 = isEditting();
        if (r0 == true) goto L7;
        onStartEdit();
    L7:
        int r1 = Selection.getSelectionStart(getText());
        int r2 = Selection.getSelectionEnd(getText());
        boolean r3 = super.onTouchEvent(r6);
        if (isFocused() == true) goto L10;
    L14:
        this.mManager.onCursorMoved();
        this.mManager.unsetTextComposingMask();
    L16:
        sendOnTouchEvent(r6);
        return r3;
    L10:
        if (getSelectState() != 0) goto L14;
        if (r0 == false) goto L13;
        this.mManager.showSoftKey(Selection.getSelectionStart(getText()), Selection.getSelectionEnd(getText()));
        goto L14
    L13:
        this.mManager.showSoftKey(r1, r2);
        goto L14
    L15:
        r3 = super.onTouchEvent(r6);
        goto L16
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedStyledTextState r1 = new SavedStyledTextState(super.onSaveInstanceState());
        r1.mBackgroundColor = this.mManager.getBackgroundColor();
        return r1;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedStyledTextState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedStyledTextState r3 = (SavedStyledTextState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setBackgroundColor(r3.mBackgroundColor);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        EditorManager r0 = this.mManager;
        if (r0 == null) goto L6;
        r0.onRefreshStyles();
        return;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int r5) {
        if (getSelectionStart() == getSelectionEnd()) goto L5;
        boolean r0 = true;
    L6:
        switch(r5) {
            case 16776961: goto L32;
            case 16776962: goto L30;
            case 16776963: goto L28;
            case 16776964: goto L26;
            default: goto L7;
        };
    L7:
        switch(r5) {
            case 16908319: goto L24;
            case 16908320: goto L20;
            case 16908321: goto L16;
            case 16908322: goto L14;
            default: goto L8;
        };
    L8:
        switch(r5) {
            case 16908328: goto L11;
            case 16908329: goto L10;
            default: goto L13;
        };
    L10:
        onFixSelectedItem();
        goto L13
    L11:
        onStartSelect();
        this.mManager.blockSoftKey();
    L13:
        return super.onTextContextMenuItem(r5);
    L14:
        onStartPaste();
        return true;
    L16:
        if (r0 == false) goto L18;
        onStartCopy();
    L19:
        return true;
    L18:
        this.mManager.onStartSelectAll(false);
        onStartCopy();
        goto L19
    L20:
        if (r0 == false) goto L22;
        onStartCut();
    L23:
        return true;
    L22:
        this.mManager.onStartSelectAll(false);
        onStartCut();
        goto L23
    L24:
        onStartSelectAll();
        return true;
    L26:
        onEndEdit();
        return true;
    L28:
        onStartEdit();
        return true;
    L30:
        onClearStyles();
        return true;
    L32:
        onInsertHorizontalLine();
        return true;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    protected void onCreateContextMenu(ContextMenu r5) {
        super.onCreateContextMenu(r5);
        MenuHandler r0 = new MenuHandler(this, null);
        CharSequence r1 = STR_HORIZONTALLINE;
        if (r1 == null) goto L6;
        r5.add(0, ID_HORIZONTALLINE, 0, r1).setOnMenuItemClickListener(r0);
    L6:
        if (isStyledText() == false) goto L11;
        CharSequence r2 = STR_CLEARSTYLES;
        if (r2 == null) goto L11;
        r5.add(0, ID_CLEARSTYLES, 0, r2).setOnMenuItemClickListener(r0);
    L11:
        if (this.mManager.canPaste() == false) goto L14;
        r5.add(0, 16908322, 0, STR_PASTE).setOnMenuItemClickListener(r0).setAlphabeticShortcut('v');
        return;
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
        EditorManager r0 = this.mManager;
        if (r0 == null) goto L15;
        r0.updateSpanNextToCursor(getText(), r4, r5, r6);
        this.mManager.updateSpanPreviousFromCursor(getText(), r4, r5, r6);
        if (r6 <= r5) goto L7;
        this.mManager.setTextComposingMask(r4, r4 + r6);
    L10:
        if (this.mManager.isWaitInput() == false) goto L15;
        if (r6 <= r5) goto L13;
        this.mManager.onCursorMoved();
        onFixSelectedItem();
        goto L15
    L13:
        if (r6 >= r5) goto L15;
        this.mManager.onAction(22);
        goto L15
    L7:
        if (r5 >= r6) goto L10;
        this.mManager.unsetTextComposingMask();
    L15:
        super.onTextChanged(r3, r4, r5, r6);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r2) {
        StyledTextInputConnection r0 = new StyledTextInputConnection(super.onCreateInputConnection(r2), this);
        this.mInputConnection = r0;
        return r0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean r1, int r2, Rect r3) {
        super.onFocusChanged(r1, r2, r3);
        if (r1 == false) goto L6;
        onStartEdit();
        return;
    L6:
        if (isButtonsFocused() == true) goto L10;
        onEndEdit();
        return;
    }

    private void init() {
        this.mConverter = new StyledTextConverter(this, this, new StyledTextHtmlStandard(this, null));
        this.mDialog = new StyledTextDialog(this);
        this.mManager = new EditorManager(this, this, this.mDialog);
        setMovementMethod(new StyledTextArrowKeyMethod(this.mManager));
        this.mDefaultBackground = getBackground();
        requestFocus();
    }

    public void setStyledTextHtmlConverter(StyledTextHtmlConverter r1) {
        this.mConverter.setStyledTextHtmlConverter(r1);
    }

    public void addEditStyledTextListener(EditStyledTextNotifier r2) {
        if (this.mESTNotifiers != null) goto L5;
        this.mESTNotifiers = new ArrayList();
    L5:
        this.mESTNotifiers.add(r2);
    }

    public void removeEditStyledTextListener(EditStyledTextNotifier r2) {
        ArrayList<EditStyledTextNotifier> r0 = this.mESTNotifiers;
        if (r0 == null) goto L8;
        int r3 = r0.indexOf(r2);
        if (r3 <= 0) goto L9;
        this.mESTNotifiers.remove(r3);
        return;
    L9:
        return;
    }

    private void sendOnTouchEvent(MotionEvent r2) {
        ArrayList<EditStyledTextNotifier> r1 = this.mESTNotifiers;
        if (r1 == null) goto L8;
        Iterator<EditStyledTextNotifier> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        r3.next().sendOnTouchEvent(r2);
        goto L6
    L10:
        return;
    }

    public boolean isButtonsFocused() {
        ArrayList<EditStyledTextNotifier> r2 = this.mESTNotifiers;
        boolean r0 = false;
        if (r2 == null) goto L8;
        Iterator<EditStyledTextNotifier> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r0 = r0 | r3.next().isButtonsFocused();
    L8:
        return r0;
    }

    private void showPreview() {
        ArrayList<EditStyledTextNotifier> r1 = this.mESTNotifiers;
        if (r1 == null) goto L9;
        Iterator<EditStyledTextNotifier> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        if (r2.next().showPreview() == false) goto L6;
        return;
    L13:
        return;
    }

    private void cancelViewManagers() {
        ArrayList<EditStyledTextNotifier> r1 = this.mESTNotifiers;
        if (r1 == null) goto L8;
        Iterator<EditStyledTextNotifier> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        r2.next().cancelViewManager();
        goto L6
    L10:
        return;
    }

    private void showInsertImageSelectAlertDialog() {
        ArrayList<EditStyledTextNotifier> r1 = this.mESTNotifiers;
        if (r1 == null) goto L9;
        Iterator<EditStyledTextNotifier> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        if (r2.next().showInsertImageSelectAlertDialog() == false) goto L6;
        return;
    L13:
        return;
    }

    private void showMenuAlertDialog() {
        ArrayList<EditStyledTextNotifier> r1 = this.mESTNotifiers;
        if (r1 == null) goto L9;
        Iterator<EditStyledTextNotifier> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        if (r2.next().showMenuAlertDialog() == false) goto L6;
        return;
    L13:
        return;
    }

    private void sendHintMessage(int r2) {
        ArrayList<EditStyledTextNotifier> r1 = this.mESTNotifiers;
        if (r1 == null) goto L8;
        Iterator<EditStyledTextNotifier> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        r3.next().sendHintMsg(r2);
        goto L6
    L10:
        return;
    }

    private void notifyStateChanged(int r2, int r3) {
        ArrayList<EditStyledTextNotifier> r1 = this.mESTNotifiers;
        if (r1 == null) goto L8;
        Iterator<EditStyledTextNotifier> r4 = r1.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        r4.next().onStateChanged(r2, r3);
        goto L6
    L10:
        return;
    }

    public void onStartEdit() {
        this.mManager.onAction(20);
    }

    public void onEndEdit() {
        this.mManager.onAction(21);
    }

    public void onResetEdit() {
        this.mManager.onAction(22);
    }

    public void onStartCopy() {
        this.mManager.onAction(1);
    }

    public void onStartCut() {
        this.mManager.onAction(7);
    }

    public void onStartPaste() {
        this.mManager.onAction(2);
    }

    public void onStartSize() {
        this.mManager.onAction(3);
    }

    public void onStartColor() {
        this.mManager.onAction(4);
    }

    public void onStartBackgroundColor() {
        this.mManager.onAction(16);
    }

    public void onStartAlign() {
        this.mManager.onAction(6);
    }

    public void onStartTelop() {
        this.mManager.onAction(8);
    }

    public void onStartSwing() {
        this.mManager.onAction(9);
    }

    public void onStartMarquee() {
        this.mManager.onAction(10);
    }

    public void onStartSelect() {
        this.mManager.onStartSelect(true);
    }

    public void onStartSelectAll() {
        this.mManager.onStartSelectAll(true);
    }

    public void onStartShowPreview() {
        this.mManager.onAction(17);
    }

    public void onStartShowMenuAlertDialog() {
        this.mManager.onStartShowMenuAlertDialog();
    }

    public void onStartAction(int r1, boolean r2) {
        this.mManager.onAction(r1, r2);
    }

    public void onFixSelectedItem() {
        this.mManager.onFixSelectedItem();
    }

    public void onInsertImage() {
        this.mManager.onAction(15);
    }

    public void onInsertImage(Uri r1) {
        this.mManager.onInsertImage(r1);
    }

    public void onInsertImage(int r1) {
        this.mManager.onInsertImage(r1);
    }

    public void onInsertHorizontalLine() {
        this.mManager.onAction(12);
    }

    public void onClearStyles() {
        this.mManager.onClearStyles();
    }

    public void onBlockSoftKey() {
        this.mManager.blockSoftKey();
    }

    public void onUnblockSoftKey() {
        this.mManager.unblockSoftKey();
    }

    public void onCancelViewManagers() {
        this.mManager.onCancelViewManagers();
    }

    private void onRefreshStyles() {
        this.mManager.onRefreshStyles();
    }

    private void onRefreshZeoWidthChar() {
        this.mManager.onRefreshZeoWidthChar();
    }

    public void setItemSize(int r2) {
        this.mManager.setItemSize(r2, true);
    }

    public void setItemColor(int r2) {
        this.mManager.setItemColor(r2, true);
    }

    public void setAlignment(Layout.Alignment r1) {
        this.mManager.setAlignment(r1);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        if (r2 == 16777215) goto L5;
        super.setBackgroundColor(r2);
    L6:
        this.mManager.setBackgroundColor(r2);
        onRefreshStyles();
        return;
    L5:
        setBackgroundDrawable(this.mDefaultBackground);
        goto L6
    }

    public void setMarquee(int r1) {
        this.mManager.setMarquee(r1);
    }

    public void setHtml(String r1) {
        this.mConverter.SetHtml(r1);
    }

    public void setBuilder(AlertDialog.Builder r1) {
        this.mDialog.setBuilder(r1);
    }

    public void setColorAlertParams(CharSequence r1, CharSequence[] r2, CharSequence[] r3, CharSequence r4) {
        this.mDialog.setColorAlertParams(r1, r2, r3, r4);
    }

    public void setSizeAlertParams(CharSequence r1, CharSequence[] r2, CharSequence[] r3, CharSequence[] r4) {
        this.mDialog.setSizeAlertParams(r1, r2, r3, r4);
    }

    public void setAlignAlertParams(CharSequence r1, CharSequence[] r2) {
        this.mDialog.setAlignAlertParams(r1, r2);
    }

    public void setMarqueeAlertParams(CharSequence r1, CharSequence[] r2) {
        this.mDialog.setMarqueeAlertParams(r1, r2);
    }

    public void setContextMenuStrings(CharSequence r1, CharSequence r2, CharSequence r3) {
        STR_HORIZONTALLINE = r1;
        STR_CLEARSTYLES = r2;
        STR_PASTE = r3;
    }

    public boolean isEditting() {
        return this.mManager.isEditting();
    }

    public boolean isStyledText() {
        return this.mManager.isStyledText();
    }

    public boolean isSoftKeyBlocked() {
        return this.mManager.isSoftKeyBlocked();
    }

    public int getEditMode() {
        return this.mManager.getEditMode();
    }

    public int getSelectState() {
        return this.mManager.getSelectState();
    }

    public String getHtml() {
        return this.mConverter.getHtml(true);
    }

    public String getHtml(boolean r1) {
        return this.mConverter.getHtml(r1);
    }

    public String getHtml(ArrayList<Uri> r3, boolean r4) {
        this.mConverter.getUriArray(r3, getText());
        return this.mConverter.getHtml(r4);
    }

    public String getPreviewHtml() {
        return this.mConverter.getPreviewHtml();
    }

    public int getBackgroundColor() {
        return this.mManager.getBackgroundColor();
    }

    public EditorManager getEditStyledTextManager() {
        return this.mManager;
    }

    public int getForegroundColor(int r3) {
        if (r3 >= 0) goto L5;
    L11:
        return -16777216;
    L5:
        if (r3 > getText().length()) goto L11;
        ForegroundColorSpan[] r2 = (ForegroundColorSpan[]) getText().getSpans(r3, r3, ForegroundColorSpan.class);
        if (r2.length <= 0) goto L11;
        return r2[0].getForegroundColor();
    }

    private void finishComposingText() {
        if (this.mInputConnection != null) goto L5;
        return;
    L5:
        if (EditorManager.access$200(this.mManager) == true) goto L9;
        this.mInputConnection.finishComposingText();
        EditorManager.access$202(this.mManager, true);
        return;
    }

    private float getPaddingScale() {
        if (this.mPaddingScale > 0.0f) goto L6;
        this.mPaddingScale = getContext().getResources().getDisplayMetrics().density;
    L6:
        return this.mPaddingScale;
    }

    private int dipToPx(int r3) {
        if (this.mPaddingScale > 0.0f) goto L6;
        this.mPaddingScale = getContext().getResources().getDisplayMetrics().density;
    L6:
        return (int) (((double) (r3 * getPaddingScale())) + 0.5d);
    }

    private int getMaxImageWidthPx() {
        return dipToPx(300);
    }

    public void addAction(int r1, EditModeActions.EditModeActionBase r2) {
        this.mManager.addAction(r1, r2);
    }

    public void addInputExtra(boolean r1, String r2) {
        Bundle r0 = super.getInputExtras(r1);
        if (r0 == null) goto L6;
        r0.putBoolean(r2, true);
        return;
    }

    private static void startSelecting(View r2, Spannable r3) {
        r3.setSpan(SELECTING, 0, 0, PRESSED);
    }

    private static void stopSelecting(View r0, Spannable r1) {
        r1.removeSpan(SELECTING);
    }
}
