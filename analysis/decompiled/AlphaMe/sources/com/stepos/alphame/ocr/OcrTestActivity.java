package com.stepos.alphame.ocr;

import B0.g;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.stepos.alphame.R;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.cutout.CutImageBinder;
import com.stepos.alphame.cutout.CutImageHelper;
import com.stepos.alphame.ocr.model.DetectResult;
import com.stepos.alphame.ocr.model.LineResult;
import com.stepos.alphame.ocr.model.OCRResult;
import com.stepos.alphame.ocr.model.PointResult;
import com.stepos.alphame.suggest.AppSuggestReport;
import com.stepos.alphame.utils.LocalConsts;
import com.stepos.alphame.utils.Utils;
import com.stepos.common.alphame.b;
import com.stepos.common.alphame.c;
import com.stepos.common.alphame.f;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class OcrTestActivity extends Activity implements View.OnClickListener {
    public static final String ACTION_OCR_DETECT = "OCR_DETECT";
    private static final String TAG = "OCR_AlphaMe";
    private static final int TYPE_BYTE = 3;
    private static final int TYPE_CUT_IMAGE_URI = 5;
    private static final int TYPE_DETECT_BYTE = 4;
    private static final int TYPE_PATH = 1;
    private static final int TYPE_URI = 2;
    private Button btnByte;
    private Button btnCut;
    private Button btnDetect;
    private Button btnPath;
    private Button btnPoint;
    private Button btnUri;
    private ImageView ivCut;
    private byte[] mDetectBitmapData;
    private TextView tvResult;
    private PointResult mAllPointResult = new PointResult();
    private b mEventReceiver = new b() { // from class: com.stepos.alphame.ocr.OcrTestActivity.1
        @Override // com.stepos.common.alphame.b
        public void onReceiver(String str, Object obj) {
            str.getClass();
            if (str.equals("OCR_DETECT")) {
                String[] strArr = (String[]) obj;
                if (strArr.length >= 2) {
                    if (strArr.length < 3 || !"point".equals(strArr[2])) {
                        try {
                            String str2 = strArr[1];
                            Log.d(OcrTestActivity.TAG, "OCR Result--------->" + str2);
                            OCRResult oCRResultFromJsonString = OCRResult.fromJsonString(str2);
                            Log.d(OcrTestActivity.TAG, "OCR Result object--------->" + oCRResultFromJsonString);
                            final StringBuilder sb = new StringBuilder();
                            sb.append("path: " + oCRResultFromJsonString.getBitmapPath());
                            sb.append("\n");
                            Iterator<LineResult> it = oCRResultFromJsonString.getLineResults().iterator();
                            while (it.hasNext()) {
                                sb.append(it.next().getText());
                                sb.append("\n");
                            }
                            OcrTestActivity.this.runOnUiThread(new Runnable() { // from class: com.stepos.alphame.ocr.OcrTestActivity.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    OcrTestActivity.this.tvResult.setText(sb.toString());
                                }
                            });
                            return;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                    try {
                        String str3 = strArr[1];
                        Log.d(OcrTestActivity.TAG, "OCR Det Result--------->" + str3);
                        DetectResult detectResultFromJsonString = DetectResult.fromJsonString(str3);
                        Log.d(OcrTestActivity.TAG, "OCR Det Result object--------->" + detectResultFromJsonString);
                        final StringBuilder sb2 = new StringBuilder();
                        List<PointResult> points = detectResultFromJsonString.getPoints();
                        for (int i4 = 0; i4 < points.size(); i4++) {
                            sb2.append(i4 + ". " + points.get(i4));
                            sb2.append("\n");
                        }
                        OcrTestActivity.this.runOnUiThread(new Runnable() { // from class: com.stepos.alphame.ocr.OcrTestActivity.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                OcrTestActivity.this.tvResult.setText(sb2.toString());
                            }
                        });
                        OcrTestActivity.this.mAllPointResult.getList().clear();
                        for (int i5 = 0; i5 < points.size(); i5++) {
                            OcrTestActivity.this.mAllPointResult.getList().addAll(points.get(i5).getList());
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    };

    private byte[] bitmap2Bytes(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private String getBitmapPath(Intent intent) throws Throwable {
        Uri data = intent.getData();
        Log.d(TAG, "getBitmapPath uri: " + data);
        String imagePath = null;
        if (DocumentsContract.isDocumentUri(this, data)) {
            String documentId = DocumentsContract.getDocumentId(data);
            if ("com.android.providers.media.documents".equals(data.getAuthority())) {
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, g.m("_id=", documentId.split(AwarenessDataItem.USERID_SPLITTER)[1]));
            } else if ("com.android,providers.downloads.documents".equals(data.getAuthority())) {
                imagePath = getImagePath(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null);
            }
        } else if ("content".equalsIgnoreCase(data.getScheme())) {
            imagePath = getImagePath(data, null);
        }
        Log.d(TAG, "getBitmapPath path: " + imagePath);
        return imagePath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap loadBitmapFromBinder(IBinder iBinder) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeString(CutImageHelper.PACKAGE_NAME_GALLERY);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                boolean zTransact = iBinder.transact(250, parcelObtain, parcelObtain2, 0);
                Log.e(TAG, "loadBitmap result: " + zTransact);
                if (zTransact) {
                    return (Bitmap) parcelObtain2.readParcelable(getClassLoader(), Bitmap.class);
                }
            } catch (RemoteException e4) {
                e4.printStackTrace();
                Log.e(TAG, "loadBitmap exception", e4);
            }
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    private void releaseImageBinder() throws RemoteException {
        Object objE = c.f11224a.e(LocalConsts.FUNC_CUT_IMAGE_ACQUIRE, CutImageHelper.PACKAGE_NAME_GALLERY);
        if (objE == null) {
            return;
        }
        try {
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeString(CutImageHelper.PACKAGE_NAME_GALLERY);
            Log.e(TAG, "loadBitmap result: " + ((IBinder) objE).transact(CutImageBinder.CODE_RELEASE, parcelObtain, Parcel.obtain(), 0));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void cutImageByUri(final String str) {
        if (TextUtils.isEmpty(str)) {
            Log.d(TAG, "cutImageByUri bitmapUri null");
        } else {
            Log.d(TAG, "cutImageByUri invoke");
            new Thread(new Runnable() { // from class: com.stepos.alphame.ocr.OcrTestActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    final Object objE = c.f11224a.e(LocalConsts.FUNC_CUT_IMAGE_BY_URI, str, CutImageHelper.PACKAGE_NAME_GALLERY, 0);
                    Log.d(OcrTestActivity.TAG, "cutImageByUri invoke result: " + ((String) objE));
                    if (objE != null) {
                        OcrTestActivity.this.runOnUiThread(new Runnable() { // from class: com.stepos.alphame.ocr.OcrTestActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                OcrTestActivity.this.tvResult.setText((String) objE);
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                Object objE2 = c.f11224a.e(LocalConsts.FUNC_CUT_IMAGE_ACQUIRE, CutImageHelper.PACKAGE_NAME_GALLERY);
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                Log.d(OcrTestActivity.TAG, "cutImageByUri invoke binder: " + objE2 + " cost: " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
                                Bitmap bitmapLoadBitmapFromBinder = OcrTestActivity.this.loadBitmapFromBinder((IBinder) objE2);
                                Log.d(OcrTestActivity.TAG, "cutImageByUri invoke bitmap: " + bitmapLoadBitmapFromBinder + " cost: " + (System.currentTimeMillis() - jCurrentTimeMillis2));
                                OcrTestActivity.this.ivCut.setImageBitmap(bitmapLoadBitmapFromBinder);
                                OcrTestActivity.this.ivCut.setVisibility(0);
                            }
                        });
                    }
                }
            }).start();
        }
    }

    public void detectOCRPointByBytes(byte[] bArr) {
        if (bArr == null) {
            Log.d(TAG, "detectOCRPointByBytes data null");
            return;
        }
        this.mEventReceiver.addAction("OCR_DETECT");
        f fVar = c.f11224a;
        fVar.g(this.mEventReceiver);
        fVar.f(this.mEventReceiver);
        Log.d(TAG, "detectOCRPointByByte invoke");
        fVar.e(LocalConsts.FUNC_DETECT_OCR_POINT_BYTE, bArr);
    }

    @SuppressLint({"Range"})
    public String getImagePath(Uri uri, String str) throws Throwable {
        String str2;
        Cursor cursorQuery;
        Cursor cursor = null;
        String string = null;
        cursor = null;
        try {
            try {
                cursorQuery = getContentResolver().query(uri, null, str, null, null);
            } catch (Exception e4) {
                e = e4;
                str2 = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("_data")) : null;
            Log.d(TAG, "query db path: " + string);
            cursorQuery.close();
            return string;
        } catch (Exception e5) {
            e = e5;
            String str3 = string;
            cursor = cursorQuery;
            str2 = str3;
            e.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        Log.d(TAG, "onActivityResult requestCode: " + i4 + " resultCode: " + i5);
        this.mDetectBitmapData = null;
        if (i4 == 1) {
            if (i5 == -1) {
                recognizeOCRByPath(getBitmapPath(intent));
                return;
            }
            return;
        }
        if (i4 == 2) {
            if (i5 == -1) {
                Uri data = intent.getData();
                recognizeOCRByUri(data != null ? data.toString() : "");
                return;
            }
            return;
        }
        if (i4 == 3) {
            if (i5 == -1) {
                recognizeOCRByBytes(bitmap2Bytes(BitmapFactory.decodeFile(getBitmapPath(intent))));
            }
        } else {
            if (i4 != 4) {
                if (i4 == 5 && i5 == -1) {
                    Uri data2 = intent.getData();
                    cutImageByUri(data2 != null ? data2.toString() : "");
                    return;
                }
                return;
            }
            if (i5 == -1) {
                byte[] bArrBitmap2Bytes = bitmap2Bytes(BitmapFactory.decodeFile(getBitmapPath(intent)));
                detectOCRPointByBytes(bArrBitmap2Bytes);
                this.mDetectBitmapData = bArrBitmap2Bytes;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Log.d(TAG, "onclick " + view);
        TextView textView = this.tvResult;
        if (textView != null) {
            textView.setText("");
        }
        ImageView imageView = this.ivCut;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (view.getId() == R.id.btn_path) {
            openAlbumAndOcrPath();
        } else if (view.getId() == R.id.btn_uri) {
            openAlbumAndOcrUri();
        } else if (view.getId() == R.id.btn_byte) {
            openAlbumAndOcrByte();
        } else if (view.getId() == R.id.btn_detect) {
            openAlbumAndDetectByte();
        } else if (view.getId() == R.id.btn_point) {
            if (this.mDetectBitmapData == null || this.mAllPointResult.getList().isEmpty()) {
                Toast.makeText(this, "请先使用按钮3获取所有点的坐标", 1).show();
            } else {
                recognizeOCRByPointBytes(this.mDetectBitmapData, this.mAllPointResult);
            }
        } else if (view.getId() == R.id.btn_cut) {
            openAlbumAndCutImage();
        }
        AppSuggestReport.testCursor();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(attributes);
        setContentView(R.layout.ocr_test_activity);
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.flags |= 1024;
        getWindow().setAttributes(attributes2);
        getWindow().addFlags(512);
        if (!Utils.DEBUG.get()) {
            finish();
        }
        this.ivCut = (ImageView) findViewById(R.id.iv_cut);
        this.tvResult = (TextView) findViewById(R.id.tv_result);
        this.btnPath = (Button) findViewById(R.id.btn_path);
        this.btnUri = (Button) findViewById(R.id.btn_uri);
        this.btnByte = (Button) findViewById(R.id.btn_byte);
        this.btnDetect = (Button) findViewById(R.id.btn_detect);
        this.btnPoint = (Button) findViewById(R.id.btn_point);
        this.btnCut = (Button) findViewById(R.id.btn_cut);
        this.btnPath.setOnClickListener(this);
        this.btnUri.setOnClickListener(this);
        this.btnByte.setOnClickListener(this);
        this.btnDetect.setOnClickListener(this);
        this.btnPoint.setOnClickListener(this);
        this.btnCut.setOnClickListener(this);
    }

    @Override // android.app.Activity
    public void onStop() throws RemoteException {
        super.onStop();
        releaseImageBinder();
    }

    public void openAlbumAndCutImage() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, 5);
    }

    public void openAlbumAndDetectByte() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, 4);
    }

    public void openAlbumAndOcrByte() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, 3);
    }

    public void openAlbumAndOcrPath() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    public void openAlbumAndOcrUri() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, 2);
    }

    public void recognizeOCRByBytes(byte[] bArr) {
        if (bArr == null) {
            Log.d(TAG, "recognizeOCRByBytes data null");
            return;
        }
        this.mEventReceiver.addAction("OCR_DETECT");
        f fVar = c.f11224a;
        fVar.g(this.mEventReceiver);
        fVar.f(this.mEventReceiver);
        Log.d(TAG, "recognizeOCRByByte invoke");
        fVar.e(LocalConsts.FUNC_RECOGNIZE_OCR_BYTE, bArr);
    }

    public void recognizeOCRByPath(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.d(TAG, "recognizeOCRByPath bitmapPath null");
            return;
        }
        this.mEventReceiver.addAction("OCR_DETECT");
        f fVar = c.f11224a;
        fVar.g(this.mEventReceiver);
        fVar.f(this.mEventReceiver);
        Log.d(TAG, "recognizeOCRByPath invoke");
        fVar.e(LocalConsts.FUNC_RECOGNIZE_OCR_PATH, str);
    }

    public void recognizeOCRByPointBytes(byte[] bArr, PointResult pointResult) {
        if (bArr == null) {
            Log.d(TAG, "recognizeOCRByPointBytes data null");
            return;
        }
        this.mEventReceiver.addAction("OCR_DETECT");
        f fVar = c.f11224a;
        fVar.g(this.mEventReceiver);
        fVar.f(this.mEventReceiver);
        Log.d(TAG, "recognizeOCRByPointByte invoke");
        fVar.e(LocalConsts.FUNC_RECOGNIZE_OCR_POINT_BYTE, bArr, pointResult.toJsonString());
    }

    public void recognizeOCRByUri(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.d(TAG, "recognizeOCRByUri bitmapUri null");
            return;
        }
        this.mEventReceiver.addAction("OCR_DETECT");
        f fVar = c.f11224a;
        fVar.g(this.mEventReceiver);
        fVar.f(this.mEventReceiver);
        Log.d(TAG, "recognizeOCRByUri invoke");
        fVar.e(LocalConsts.FUNC_RECOGNIZE_OCR_URI, str);
    }
}
