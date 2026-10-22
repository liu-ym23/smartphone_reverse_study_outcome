package com.zyql.ai.selector.tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.config.PictureMimeType;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class StringUtils {
    public static String getEncryptionValue(long j10, int i10, int i11) {
        if (i10 == 0 && i11 == 0) {
            return "";
        }
        return j10 + "_" + i10 + i11;
    }

    @SuppressLint({"StringFormatMatches"})
    public static String getMsg(Context context, String str, int i10) {
        return PictureMimeType.isHasVideo(str) ? context.getString(R.string.picture_message_video_max_num, Integer.valueOf(i10)) : PictureMimeType.isHasAudio(str) ? context.getString(R.string.picture_message_audio_max_num, Integer.valueOf(i10)) : context.getString(R.string.picture_message_max_num, Integer.valueOf(i10));
    }

    public static String rename(String str) {
        return str.substring(0, str.lastIndexOf(".")) + "_" + DateUtils.getCreateFileName() + str.substring(str.lastIndexOf("."));
    }

    public static String renameSuffix(String str, String str2) {
        return str.substring(0, str.lastIndexOf(".")) + str2;
    }

    public static int stringToInt(String str) {
        if (Pattern.compile("^[-\\+]?[\\d]+$").matcher(str).matches()) {
            return ValueOf.toInt(str);
        }
        return 0;
    }

    public static void tempTextFont(TextView textView, int i10) {
        String strTrim = textView.getText().toString().trim();
        String string = i10 == PictureMimeType.ofAudio() ? textView.getContext().getString(R.string.picture_empty_audio_title) : textView.getContext().getString(R.string.picture_empty_title);
        String str = string + strTrim;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new RelativeSizeSpan(0.8f), string.length(), str.length(), 33);
        textView.setText(spannableString);
    }
}
